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
    public List<User> ds() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Select * From User");

        return q.getResultList();
    }
    
}
