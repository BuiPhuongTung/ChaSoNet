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
import com.ttp.pojos.AuctionComment;

import java.util.List;

public interface AuctionCommentService {
    List<AuctionComment> getMyAuctionCommentByAuctionId(Integer auctionId, Integer uid);
    AuctionComment addAuctionComment(AuctionComment auctionComment);
    List<AuctionComment> getCommentByAuctionId(Integer id);
}
