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
import com.ttp.pojos.FeedImage;
import com.ttp.repository.FeedImageRepository;
import com.ttp.service.FeedImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedImageServiceImpl implements FeedImageService {
    @Autowired private FeedImageRepository feedImageRepository;

    @Override
    public List<FeedImage> getImageByFeedId(Integer feedId) {
        return this.feedImageRepository.getImageByFeedId(feedId);
    }

    @Override
    public boolean addFeedImage(FeedImage feedImage) {
        return this.feedImageRepository.addFeedImage(feedImage);
    }
}
