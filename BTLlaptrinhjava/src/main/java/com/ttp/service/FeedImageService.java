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
import com.ttp.pojos.FeedImage;

import java.util.List;

public interface FeedImageService {
    List<FeedImage> getImageByFeedId(Integer feedId);
    boolean addFeedImage(FeedImage feedImage);
}
