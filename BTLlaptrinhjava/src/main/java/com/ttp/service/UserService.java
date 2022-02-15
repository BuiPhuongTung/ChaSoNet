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
import com.ttp.pojos.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getUsers();

    User getUserById(Integer id);

    User getUserByUsername(String username);

    boolean addUser(User user);
}