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
import com.ttp.pojos.Auction;
import com.ttp.pojos.Feed;
import com.ttp.pojos.Report;
import com.ttp.pojos.User;
import com.ttp.service.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author kan_ttp
 */
@Controller
@ControllerAdvice
public class HomeController {
    @Autowired private CategoryService categoryService;
    @Autowired private TypeReportService typeReportService;
    @Autowired private FeedService feedService;
    @Autowired private AuctionService auctionService;

    @ModelAttribute
    public void commonAttrs(Model model, HttpSession session) {
        model.addAttribute("categories", this.categoryService.getCategories());
    }

    @RequestMapping(value = {"/", "/login", "/register", "/create-auction", "/create-feed"}, method = RequestMethod.GET)
    public String index(Model model, @RequestParam Map<String, String> params, HttpSession session) {
        List<Feed> feeds = this.feedService.getFeeds(params);
        List<Auction> auctions = this.auctionService.getAuctions(params);

        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser != null){
            model.addAttribute("auction", new Auction());
            model.addAttribute("feed", new Feed());
            model.addAttribute("currentUser", currentUser);
            model.addAttribute("typeReports", this.typeReportService.getTypeReports());
            for (Feed feed: feeds){
                feed.checkIsLike(currentUser.getId());
            }
        } else if (model.getAttribute("user") == null) {
            model.addAttribute("user", new User());
        }
        model.addAttribute("feeds", feeds);
        model.addAttribute("auctions", auctions);
        return "index";
    }
}
