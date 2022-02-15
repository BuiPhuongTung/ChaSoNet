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
import com.ttp.service.AuctionCommentService;
import com.ttp.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@RestController
public class ApiAuctionController {
    @Autowired private AuctionService auctionService;
    @Autowired private AuctionCommentService auctionCommentService;

    @PostMapping(value = "/api/set-winner/{uid}/{auctionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus setWinner(@PathVariable Integer commentId, @PathVariable Integer auctionId, HttpSession session) {
        User user = (User) session.getAttribute("currentUser");

        Auction auction = this.auctionService.getAuctionById(auctionId);
        if (auction == null || !auction.getUser().getId().equals(user.getId()) || !auction.getStatusAuction().equals(StatusAuction.being.toString()))
            return HttpStatus.BAD_REQUEST;
        if (!this.auctionService.setBuyler(commentId, auctionId)) return HttpStatus.BAD_REQUEST;

        return  HttpStatus.OK;
    }

}
