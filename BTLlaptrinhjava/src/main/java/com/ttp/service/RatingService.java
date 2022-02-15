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
import com.ttp.pojos.Rating;

import java.util.List;

public interface RatingService {
    List<Rating> getRatingByUserId(Integer uid);
    List<Rating> getRatingByAuctionId(Integer id);
    Rating addRating(Rating rating);
}
