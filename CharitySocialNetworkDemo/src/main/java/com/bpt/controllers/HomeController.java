/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpt.controllers;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pojos.User;

/**
 *
 * @author ACER
 */
@Controller
public class HomeController {
    @RequestMapping("/")
<<<<<<< HEAD
    public String index(Model model){
        model.addAttribute("name","Phong");
=======
    public String index(Model model, 
           @RequestParam Map<String,String> params){
        String firstName = params.get("first_name");
        String lastName = params.get("last_name");
        if (firstName != null && lastName != null)
            model.addAttribute("name", String.format("%s %s", firstName, lastName));
        else 
            model.addAttribute("name", "Tung");
        model.addAttribute("user", new User());
        return "index";
    }
    
    @RequestMapping("/hello/{name}")
    public String hello(Model model,@PathVariable(value = "name") String name){
        model.addAttribute("message", "Welcome " + name + " !!!");
        
        return "hello";
    }
    
    @RequestMapping(path="/hello-post",method=RequestMethod.POST)
    public String helloPost(Model model,@ModelAttribute(value = "user") User user){
        model.addAttribute("fullName", user.getFirstName() + " " + user.getLastName());
        
>>>>>>> 6c5d62d13831c2a008bf334b1b17c2b196e71bdf
        return "index";
    }
}
