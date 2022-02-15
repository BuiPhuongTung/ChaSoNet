/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttp.repository.impl;

/**
 *
 * @author Hau Exoty
 */
import com.ttp.pojos.Auction;
import com.ttp.pojos.Category;
import com.ttp.pojos.Feed;
import com.ttp.pojos.FeedComment;
import com.ttp.repository.FeedCommentRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class FeedCommentRepositoryImpl implements FeedCommentRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public FeedComment getFeedCommentById(Integer id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        return session.get(FeedComment.class, id);
    }

    @Override
    public FeedComment addFeedComment(FeedComment feedComment) {
        Session session = sessionFactory.getObject().getCurrentSession();
        feedComment.setCreateAt(new Date());
        try{
            Feed feed = session.get(Feed.class, feedComment.getFeed().getId());
            feed.setCountComment(feed.getCountComment() + 1);
            session.update(feed);
            session.save(feedComment);
            return feedComment;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<FeedComment> getFeedCommentByFeedId(Integer id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM FeedComment F WHERE F.feed.id=:id ORDER BY F.createAt DESC");
        q.setParameter("id", id);
        return q.getResultList();
    }

    @Override
    public boolean removeComment(Integer id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try {
            FeedComment feedComment = session.get(FeedComment.class, id);
            Feed feed = feedComment.getFeed();
            feed.setCountComment(feed.getCountComment() - 1);
            session.update(feed);

            if (feedComment != null){
                session.delete(feedComment);
                return true;
            }
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }
}
