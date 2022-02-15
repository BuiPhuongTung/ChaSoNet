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
import com.ttp.pojos.User;
import com.ttp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 *
 * @author kan_ttp
 */
@Controller
public class UserController {

    @Autowired
    private UserService userDetailsService;
    @Autowired
    private AuctionService auctionService;
    @Autowired
    private TypeReportService typeReportService;
    @Autowired
    private RatingService ratingService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addUser(Model model, @ModelAttribute(value = "user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "index";
        }
        if (this.userDetailsService.addUser(user)) {
            model.addAttribute("user", user);
            return "redirect:/login";
        }

        model.addAttribute("messageErrorRegister", "Tên đăng nhập đã tồn tại");
        return "index";
    }

    @RequestMapping(value = {"/user/{id}"}, method = RequestMethod.GET)
    public String userDetail(Model model, @PathVariable String id, HttpSession session) {
        //Check login send feed, auction for create, and current user
        User currentUser = (User) session.getAttribute("currentUser");
        User user = this.userDetailsService.getUserById(Integer.parseInt(id));
        List<Auction> auctions = this.auctionService.getMyAuction(Integer.parseInt(id));
        model.addAttribute("user", user);
        model.addAttribute("typeReports", this.typeReportService.getTypeReports());
        model.addAttribute("auctions", auctions);
        model.addAttribute("ratings", this.ratingService.getRatingByUserId(Integer.parseInt(id)));
        return "user";
    }
}