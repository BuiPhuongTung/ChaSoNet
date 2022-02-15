/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttp.service.impl;

/**
 *
 * @author Hau Exoty
 */
import com.ttp.pojos.Feed;
import com.ttp.pojos.FeedComment;
import com.ttp.pojos.User;
import com.ttp.repository.FeedCommentRepository;
import com.ttp.service.FeedCommentService;
import com.ttp.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedCommentServiceImpl implements FeedCommentService {
    @Autowired private FeedCommentRepository feedCommentRepository;
    @Autowired private FeedService feedService;

    @Override
    public FeedComment getFeedCommentById(Integer id) {
        return this.feedCommentRepository.getFeedCommentById(id);
    }

    @Override
    public FeedComment addFeedComment(FeedComment feedComment) {
        FeedComment feedComment1 = this.feedCommentRepository.addFeedComment(feedComment);

        if (feedComment1 != null){
            return feedComment1;
        }
        return null;
    }

    @Override
    public List<FeedComment> getFeedCommentByFeedId(Integer id) {
        return this.feedCommentRepository.getFeedCommentByFeedId(id);
    }

    @Override
    public boolean removeComment(Integer id) {
        return this.feedCommentRepository.removeComment(id);
    }
}
