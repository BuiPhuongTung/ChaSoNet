/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpt.controllers;


import com.bpt.pojos.User;
import com.bpt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Hau Exoty
 */
@Controller
public class UserController {
    @Autowired
    private UserService userDetailsService;
    
    @GetMapping("/login")
    public String login(){
        return "login";
    
    }
    
    @GetMapping("/register")
    public String registerView(Model model){
        model.addAttribute("user", new User());
        return "register";
    }
    
    @PostMapping("/register")
    public String register(Model model, @ModelAttribute(value = "user") User user){
        String errMsg = "";
        
        if(user.getPassWord().equals(user.getConfirmPassword())){
            if(this.userDetailsService.addUser(user) == true)
                return "redirect:/login";
            else 
                errMsg = "Da co loi xay ra";
        }else
            errMsg = "Mat khau khong khop";
        model.addAttribute("errMsg", errMsg);
        return "register";
    }
}
