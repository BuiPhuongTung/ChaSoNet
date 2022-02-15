/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttp.configs.handlers;

/**
 *
 * @author Hau Exoty
 */
import com.ttp.pojos.User;
import com.ttp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private UserService userDetailsService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication a) throws IOException, ServletException {
        User u = this.userDetailsService.getUserByUsername(a.getName());
        request.getSession().setAttribute("currentUser", u);
        if (u.getUserRole().equals(User.ADMIN)) response.sendRedirect("/BTLlaptrinhjava/admin");
        else response.sendRedirect("/BTLlaptrinhjava/");
    }
}
