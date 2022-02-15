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
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ttp.pojos.Auction;
import com.ttp.pojos.AuctionImage;
import com.ttp.repository.AuctionRepository;
import com.ttp.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class AuctionServiceImpl implements AuctionService {

    @Autowired private AuctionRepository auctionRepository;
    @Autowired private Cloudinary cloudinary;

    @Override
    public List<Auction> getAuctions(Map<String, String> params) {
        return this.auctionRepository.getAuctions(params);
    }

    @Override
    public Auction getAuctionById(Integer id) {
        return this.auctionRepository.getAuctionById(id);
    }

    @Override
    public Auction addAuction(Auction auction) {
        List<MultipartFile> files = auction.getFiles();

        if (null != files && files.size() > 0) { //Add image to auction
            Map params = ObjectUtils.asMap(
                    "folder", "assets/auction",
                    "overwrite", true,
                    "resource_type", "auto"
            );
            Set<AuctionImage> auctionImages = new HashSet<>();
            for (MultipartFile multipartFile : files) {
                try {
                    Map r = this.cloudinary.uploader().upload(multipartFile.getBytes(), params);
                    String imageUrl = (String) r.get("secure_url");
                    auctionImages.add(new AuctionImage(imageUrl));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            auction.setImages(auctionImages);
        }
        return this.auctionRepository.addAuction(auction);
    }

    @Override
    public List<Auction> getMyAuction(Integer uid) {
        return this.auctionRepository.getMyAuction(uid);
    }

    @Override
    public List<Auction> getAuctionJoin(Integer uid) {
        return this.auctionRepository.getAuctionJoin(uid);
    }

    @Override
    public boolean setBuyler(Integer commentId, Integer auctionId) {
        return this.auctionRepository.setBuyler(commentId, auctionId);
    }

    @Override
    public boolean setFailer(Integer commentId, Integer auctionId) {
        return this.auctionRepository.setFailer(commentId, auctionId);
    }

    @Override
    public boolean cancelAuction(Integer auctionId) {
        return this.auctionRepository.cancelAuction(auctionId);
    }
}
