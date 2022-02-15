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
import com.ttp.pojos.AuctionComment;
import com.ttp.repository.AuctionCommentRepository;
import com.ttp.service.AuctionCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionCommentServiceImpl implements AuctionCommentService {
    @Autowired private AuctionCommentRepository auctionCommentRepository;

    @Override
    public List<AuctionComment> getMyAuctionCommentByAuctionId(Integer auctionId, Integer uid) {
        return this.auctionCommentRepository.getMyAuctionCommentByAuctionId(auctionId, uid);
    }

    @Override
    public AuctionComment addAuctionComment(AuctionComment auctionComment) {
        return this.auctionCommentRepository.addAuctionComment(auctionComment);
    }

    @Override
    public List<AuctionComment> getCommentByAuctionId(Integer id) {
        return this.auctionCommentRepository.getCommentByAuctionId(id);
    }
}
