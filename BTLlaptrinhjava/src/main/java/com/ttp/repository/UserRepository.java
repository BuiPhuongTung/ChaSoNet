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
import com.ttp.pojos.User;
import java.util.List;

public interface UserRepository {

    List<User> getUsers();

    User getUserByUsername(String username);

    User getUserById(Integer userId);

    boolean addUser(User user);
}
