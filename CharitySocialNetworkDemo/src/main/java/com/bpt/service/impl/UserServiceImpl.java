/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpt.service.impl;

import com.bpt.pojos.User;
import com.bpt.reponsitory.UserReponsitory;
import com.bpt.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hau Exoty
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserReponsitory userReponsitory;
    
    @Override
    public List<User> ds() {
        return this.userReponsitory.ds();
    }
    
}
