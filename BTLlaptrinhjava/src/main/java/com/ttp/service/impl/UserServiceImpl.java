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
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ttp.pojos.User;
import com.ttp.repository.UserRepository;
import com.ttp.service.UserService;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author kan_ttp
 */

@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired private Cloudinary cloudinary;
    @Autowired private BCryptPasswordEncoder passwordEncoder;
    @Autowired private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return this.userRepository.getUsers();
    }

    @Override
    public User getUserById(Integer id) {
        User user = this.userRepository.getUserById(id);
        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        User user = this.userRepository.getUserByUsername(username);
        return user;
    }

    @Override
    public boolean addUser(User user) {
        //check usernamr exsit
        User u = this.userRepository.getUserByUsername(user.getUsername());
        if (u != null) return false;

        try {
            String pass = user.getPassword();
            user.setPassword(this.passwordEncoder.encode(pass));
            user.setUserRole(User.USER);

            Map params = ObjectUtils.asMap(
                    "folder", "assets/avatar",
                    "overwrite", true,
                    "resource_type", "auto"
            );

            Map r = this.cloudinary.uploader().upload(user.getFile().getBytes(), params);
            String avatarUrl = (String) r.get("secure_url");
            user.setAvatar(avatarUrl);
            return this.userRepository.addUser(user);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.getUserByUsername(username);
        if (user == null){ //check user exsit
            throw new UsernameNotFoundException("Ng?????i d??ng kh??ng t???n t???i");
        }

        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(user.getUserRole()));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), auth
        );
    }
}
