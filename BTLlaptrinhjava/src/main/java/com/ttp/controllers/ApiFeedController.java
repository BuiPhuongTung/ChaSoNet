/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttp.controllers;

/**
 *
 * @author Hau Exoty
 */
import com.ttp.pojos.*;
import com.ttp.service.FeedCommentService;
import com.ttp.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.util.*;

@RestController
public class ApiFeedController {
    @Autowired private FeedService feedService;
    @Autowired private FeedCommentService feedCommentService;

    @GetMapping(value = "/api/comment/{feedId}")
    public ResponseEntity<List<FeedComment>> getComment(@PathVariable Integer feedId){
        List<FeedComment> feedComments = this.feedCommentService.getFeedCommentByFeedId(feedId);
        return new ResponseEntity(feedComments, HttpStatus.OK);
    }

    @GetMapping(value = "/api/getMoreFeed")
    public ResponseEntity<List<Feed>> getMoreFeed(@RequestParam Map<String, String> params, HttpSession session){
        List<Feed> feeds = this.feedService.getFeeds(params);
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser != null){
            for (Feed feed: feeds){
                feed.checkIsLike(currentUser.getId());
                feed.setCountLike(feed.getLikes().size());
            }
        }
        if (feeds == null || feeds.size() == 0) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(feeds, HttpStatus.OK);
    }

    @PostMapping(value = "/api/like-feed", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus likeFeed(@RequestBody Map<String, String> params, HttpSession session) {
        Integer id = Integer.parseInt(params.getOrDefault("feedId", null));
        User user = (User) session.getAttribute("currentUser");

        if (id != null && this.feedService.addLike(user, id, user.getId())) {
            return HttpStatus.OK;
        }
        else
            return HttpStatus.BAD_REQUEST;
    }

    @PostMapping(value = "/api/dislike-feed", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus dislikeFeed(@RequestBody Map<String, String> params, HttpSession session) {
        Integer id = Integer.parseInt(params.getOrDefault("feedId", null));
        User user = (User) session.getAttribute("currentUser");
        if (id != null && this.feedService.removeLike(id, user.getId()))
            return HttpStatus.OK;
        else
            return HttpStatus.BAD_REQUEST;
    }

    @PostMapping(value = "/api/add-comment/{feedId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeedComment> createFeedComment(@RequestBody FeedComment feedComment, @PathVariable Integer feedId, HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        Feed feed = this.feedService.getFeedById(feedId);
        if (feed == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        feedComment.setFeed(feed);
        feedComment.setUser(user);
        FeedComment feedComment1 = this.feedCommentService.addFeedComment(feedComment);
        if (feedComment1 == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<FeedComment>(feedComment1, HttpStatus.OK);
    }

    @PostMapping(value = "/api/update-feed", produces = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public HttpStatus updateFeed(@RequestBody Feed feed, HttpSession session) {
        if (feed.isCanUpdate() == false) return HttpStatus.BAD_REQUEST;
        feed.setId(Integer.parseInt(feed.getFeedId()));
        Feed rs = this.feedService.updateFeed(feed);
        if (rs!= null)
            return HttpStatus.OK;
        return HttpStatus.BAD_REQUEST;
    }

    @DeleteMapping(value = "/api/remove-comment/{commentId}")
    public HttpStatus deleteFeedComment(@PathVariable Integer commentId, HttpSession session) {
        User user = (User) session.getAttribute("currentUser");

        if (this.feedCommentService.removeComment(commentId))
            return HttpStatus.OK;
        else
            return HttpStatus.BAD_REQUEST;
    }
    @DeleteMapping(value = "/api/remove-feed", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus deleteFeed(@RequestBody Map<String, String> params, HttpSession session) {
        Integer id = Integer.parseInt(params.getOrDefault("feedId", null));
        User user = (User) session.getAttribute("currentUser");

        //check resource owner
        if (this.feedService.getFeedById(id).getUser().getId() != user.getId()) return HttpStatus.BAD_REQUEST;

        if (id != null && this.feedService.removeFeed(id))
            return HttpStatus.OK;
        else
            return HttpStatus.BAD_REQUEST;
    }
}
