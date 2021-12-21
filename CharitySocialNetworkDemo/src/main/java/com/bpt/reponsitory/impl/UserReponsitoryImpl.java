/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpt.reponsitory.impl;

import com.bpt.pojos.User;
import com.bpt.reponsitory.UserReponsitory;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hau Exoty
 */
@Repository
@Transactional
public class UserReponsitoryImpl implements UserReponsitory{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addUser(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(user);
            System.out.println(user.getFirstName() + " " + user.getLastName() + " "+ user.getPassWord() + " " + user.getConfirmPassword() + " " + user.getId());
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<User> getUsers(String userName) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query = query.select(root);
        
        if(!userName.isEmpty()){
            Predicate p = builder.equal(root.get("userName").as(String.class), userName.trim());
            query = query.where(p);
            
        }
        
        Query q = session.createQuery(query);
        return q.getResultList();
    }
    
}
