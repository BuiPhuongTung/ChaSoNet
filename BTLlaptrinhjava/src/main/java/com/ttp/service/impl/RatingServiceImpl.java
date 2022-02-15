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
import com.ttp.pojos.Rating;
import com.ttp.service.RatingRepository;
import com.ttp.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired private RatingRepository ratingRepository;
    @Override
    public List<Rating> getRatingByUserId(Integer uid) {
        return this.ratingRepository.getRatingByUserId(uid);
    }

    @Override
    public List<Rating> getRatingByAuctionId(Integer id) {
        return this.ratingRepository.getRatingByAuctionId(id);
    }

    @Override
    public Rating addRating(Rating rating) {
        return this.ratingRepository.addRating(rating);
    }
}
