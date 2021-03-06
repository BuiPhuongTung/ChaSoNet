/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttp.configs;

/**
 *
 * @author Hau Exoty
 */
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ttp.configs.handlers.LoginSuccessHandler;
import com.ttp.configs.handlers.LogoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.ttp.repository",
    "com.ttp.service"
})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired private UserDetailsService userDetailsService;
    @Autowired private AuthenticationSuccessHandler loginSuccessHandler;
    @Autowired private LogoutSuccessHandler logoutHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dk1xrtgfi",
                "api_key", "463854142197545",
                "api_secret", "2NTr8a9BFinnxKEuub_2IfkjzTg",
                "secure", true));
        return cloudinary;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler() {
        return new LoginSuccessHandler();
    }

    @Bean
    public LogoutSuccessHandler logoutHandler() {
        return new LogoutHandler();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password");

        http.formLogin().successHandler(this.loginSuccessHandler).failureUrl("/login?error");
        http.logout().logoutSuccessHandler(this.logoutHandler);
        http.exceptionHandling().accessDeniedPage("/");

        http.authorizeRequests().antMatchers("/").permitAll()
//              .antMatchers("/api/**").access("hasRole('ROLE_USER')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/**/auctionJoin").access("hasAnyRole('ROLE_USER')");
        http.csrf().disable();
    }
}
