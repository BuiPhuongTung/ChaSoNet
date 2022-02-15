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
import com.ttp.pojos.Feed;
import com.ttp.pojos.FeedComment;
import com.ttp.pojos.User;

import java.util.List;
import java.util.Map;

public interface FeedService {
    List<Feed> getFeeds(Map<String, String> params);
    Feed getFeedById(Integer id);
    Feed addFeed(Feed feed);
    Feed updateFeed(Feed feed);
    boolean removeFeed(Integer id);
    boolean addLike(User user, Integer id, Integer uid);
    boolean removeLike(Integer id, Integer uid);
}
