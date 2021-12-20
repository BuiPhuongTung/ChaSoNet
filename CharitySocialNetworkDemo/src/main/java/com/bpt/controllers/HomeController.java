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
import com.bpt.pojos.User;
<<<<<<< HEAD
import com.bpt.service.UserService;
import java.util.List;
=======
>>>>>>> 5c94eeab34c013143e389724a13a23c8cf297888
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.Transactional;

@Controller
public class HomeController {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
<<<<<<< HEAD
    @Autowired
    private UserService userService;
    
    @RequestMapping("/")
    @Transactional
    public String index(Model model) {
//            @RequestParam Map<String,String> params){
//        String firstName = params.get("first_name")   ;
//        String lastName = params.get("last_name");
//        if (firstName != null && lastName != null)
//            model.addAttribute("name", String.format("%s %s", firstName, lastName));
//        else 
//            model.addAttribute("name", "Tung");
//        model.addAttribute("user", new User());
//        Session s = sessionFactory.getObject().getCurrentSession();
//        Query q = s.createNamedQuery("From User");
        model.addAttribute("users", this.userService.ds());
//        s.close();
=======

    @RequestMapping("/")
    @Transactional
    public String index(Model model) {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Comments");

        model.addAttribute("comments", q.getResultList());
>>>>>>> 5c94eeab34c013143e389724a13a23c8cf297888

        return "index";
    }

    @RequestMapping("/hello/{name}")
    public String hello(Model model, @PathVariable(value = "name") String name) {
        model.addAttribute("message", "Welcome " + name + " !!!");

        return "hello";
    }

    @RequestMapping(path = "/hello-post", method = RequestMethod.POST)
    public String helloPost(Model model, @ModelAttribute(value = "user") User user) {
        model.addAttribute("fullName", user.getFirstName() + " " + user.getLastName());
<<<<<<< HEAD
=======

>>>>>>> 5c94eeab34c013143e389724a13a23c8cf297888
        return "index";
    }

    @RequestMapping(path = "/test")
    public String testRedirect(Model model) {
        model.addAttribute("testMsg", "Welcome to website!!!");

        return "redirect:/hello/Tung"; //forward
    }
}
