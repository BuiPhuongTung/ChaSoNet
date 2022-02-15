/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttp.repository;

/**
 *
 * @author Hau Exoty
 */
import com.ttp.pojos.FeedComment;

import java.util.List;

public interface FeedCommentRepository {
    FeedComment getFeedCommentById(Integer id);
    FeedComment addFeedComment(FeedComment feedComment);
    List<FeedComment> getFeedCommentByFeedId(Integer id);
    boolean removeComment(Integer id);
}
