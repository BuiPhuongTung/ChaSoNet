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
import com.ttp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kan_ttp
 */
@Controller
@ControllerAdvice
public class AuctionController {
    @Autowired private AuctionService auctionService;
    @Autowired private CategoryService categoryService;
    @Autowired private AuctionCommentService auctionCommentService;
    @Autowired private TypeReportService typeReportService;

    @ModelAttribute
    public void commonAttrs(Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");

        if (currentUser != null){
            model.addAttribute("currentUser", currentUser);
        } else if (model.getAttribute("user") == null) {
            model.addAttribute("user", new User());
        }
    }

    @RequestMapping(value = {"/category"}, method = RequestMethod.GET)
    public String index(Model model, @RequestParam Map<String, String> params, HttpSession session) {
        List<Auction> auctions = this.auctionService.getAuctions(params);
        List<Category> categories = this.categoryService.getCategories();

        String type = params.getOrDefault("id", null);
        if (type == null){
            model.addAttribute("typeCategory", "T???t c???");
        } else {
            for (Category category: categories){
                if (category.getId().equals(Integer.parseInt(type))) {
                    model.addAttribute("typeCategory", category.getName());
                    break;
                }
            }
        }

        model.addAttribute("auctions", auctions);
        model.addAttribute("categories", categories);

        return "category";
    }

    @RequestMapping(value = {"/auctionJoin"}, method = RequestMethod.GET)
    public String auctionJoin(Model model, HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        if (user == null) return "auctionJoin";
        List<Auction> auctions = this.auctionService.getAuctionJoin(user.getId());
        model.addAttribute("auctions", auctions);
        return "auctionJoin";
    }

    @RequestMapping(value = {"/auction/{id}"}, method = RequestMethod.GET)
    public String auctionDetail(Model model,@PathVariable String id, HttpSession session) {
        Auction auction = this.auctionService.getAuctionById(Integer.parseInt(id));
        model.addAttribute("auction", auction);
        model.addAttribute("auctionComment", new AuctionComment());
        User user = (User) session.getAttribute("currentUser");

        if (user == null){
            return "auctionDetail";
        } else if (user.getId().equals(auction.getUser().getId())){
            List<AuctionComment> auctionComments = this.auctionCommentService.getCommentByAuctionId(auction.getId());
            model.addAttribute("comments", auctionComments);
        } else if (!auction.getCountComment().equals(0)) {
            List<AuctionComment> auctionComments = this.auctionCommentService.getMyAuctionCommentByAuctionId(auction.getId(), user.getId());
            model.addAttribute("comments", auctionComments);
        }
        model.addAttribute("typeReports", this.typeReportService.getTypeReports());
        return "auctionDetail";
    }

    @PostMapping(value = "/add-auction-comment/{auctionId}")
    public String createAuctionComment(@ModelAttribute AuctionComment auctionComment, @PathVariable String auctionId,
                                       Model model, HttpSession session, BindingResult result) {
        if (result.hasErrors()){
            return String.format("forward:/auction/%s", auctionId);
        }
        Auction auction = this.auctionService.getAuctionById(Integer.parseInt(auctionId));
        User user = (User) session.getAttribute("currentUser");
        auctionComment.setAuctionId(Integer.parseInt(auctionId));
        auctionComment.setUserId(user.getId());

        AuctionComment rs = this.auctionCommentService.addAuctionComment(auctionComment);
        if (rs == null){
            model.addAttribute("messageErrorCreateAuctionComment", "???? c?? l???i x???y ra vui l??ng th??? l???i");
            return String.format("forward:/auction/%s", auctionId);
        }

        return String.format("redirect:/auction/%s", auctionId);
    }

    @PostMapping(value = "/create-auction")
    public String createAuction(@ModelAttribute Auction auction, Model model, HttpSession session, BindingResult result) {
        if (result.hasErrors()){
            return "index";
        }
        try {
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(auction.getDate());
            auction.setDeadline(date1);
            auction.setUser((User) session.getAttribute("currentUser"));
            Auction rs = this.auctionService.addAuction(auction);
            if (rs == null){
                model.addAttribute("messageErrorCreateAuction", "???? c?? l???i x???y ra vui l??ng th??? l???i");
                return "index";
            }
        } catch (ParseException e) {
            e.printStackTrace();
            model.addAttribute("messageErrorCreateAuction", "???? c?? l???i x???y ra vui l??ng th??? l???i");
        }
        return "redirect:/";
    }
}
