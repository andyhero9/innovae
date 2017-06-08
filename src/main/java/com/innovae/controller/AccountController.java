package com.innovae.controller;

import com.google.gson.Gson;
import com.innovae.domain.UserDomain;
import com.innovae.model.User;
import com.innovae.service.AccountService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

/**
 * Created by Polotin on 2017/5/19.
 */
@CrossOrigin
@RestController
@RequestMapping(value = "account",method = {RequestMethod.GET, RequestMethod.POST})
public class AccountController{
    private static Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    AccountService accountService;

    @ResponseBody
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public boolean login(User user, HttpServletRequest request, HttpServletResponse response) throws Exception{
        UserDomain userDomain = accountService.UserLogin(user);
        if(userDomain.getResult() == 1){
            request.getSession().setAttribute("id", userDomain.getId());
            request.getSession().setAttribute("name", userDomain.getUserName());
            request.getSession().setAttribute("password", user.getPassword());
            response.sendRedirect("/forum");
            return true;
        } else {
            Cookie cookie = new Cookie("err","error");
            cookie.setMaxAge(10);
            cookie.setPath("/");
            response.addCookie(cookie);
            response.sendRedirect("/login");
            return false;
        }
    }


    @ResponseBody
    @RequestMapping(value = "/register", method = {RequestMethod.GET, RequestMethod.POST})
    public boolean register(User user, HttpServletRequest request, HttpServletResponse response) throws Exception{
        UserDomain userDomain = accountService.UserRegister(user);
        if(userDomain.getResult() == 1){
            request.getSession().setAttribute("id", userDomain.getId());
            request.getSession().setAttribute("name", userDomain.getUserName());
            request.getSession().setAttribute("password", user.getPassword());
            response.sendRedirect("/forum");
            return true;
        } else {
            Cookie cookie = new Cookie("reg_err","error");
            cookie.setMaxAge(10);
            cookie.setPath("/");
            response.addCookie(cookie);
            response.sendRedirect("/login");
            return false;
        }
    }
}
