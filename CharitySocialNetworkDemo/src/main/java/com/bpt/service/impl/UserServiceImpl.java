/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpt.service.impl;

import com.bpt.pojos.User;
import com.bpt.reponsitory.UserReponsitory;
import com.bpt.service.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hau Exoty
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserReponsitory userReponsitory;

    @Override
    public boolean addUser(User user) {
        return this.userReponsitory.addUser(user);
    }

    @Override
    public List<User> getUsers(String userName) {
        return this.userReponsitory.getUsers(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        List<User> users = this.getUsers(userName);
        if(users.isEmpty())
            throw new UsernameNotFoundException("User does not exist !!!");
        User user = users.get(0);
        
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(user.getRole()));
        
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassWord(), auth);
    }
    
}
