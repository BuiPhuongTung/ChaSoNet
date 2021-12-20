/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpt.reponsitory;

import com.bpt.pojos.User;
import java.util.List;

/**
 *
 * @author Hau Exoty
 */
public interface UserReponsitory {
    boolean addUser(User user);
    List<User> getUsers(String userName);
}
