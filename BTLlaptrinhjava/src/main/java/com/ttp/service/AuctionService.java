/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttp.service;

/**
 *
 * @author Hau Exoty
 */
import com.ttp.pojos.Auction;
import com.ttp.pojos.AuctionComment;

import java.util.List;
import java.util.Map;

public interface AuctionService {
    List<Auction> getAuctions(Map<String, String> params);
    Auction getAuctionById(Integer id);
    Auction addAuction(Auction auction);
    List<Auction> getMyAuction(Integer uid);
    List<Auction> getAuctionJoin(Integer uid);
    boolean setBuyler(Integer commentId, Integer auctionId);
    boolean setFailer(Integer commentId, Integer auctionId);
    boolean cancelAuction(Integer auctionId);
}
