package com.innovae.controller;

import com.google.gson.Gson;
import com.innovae.domain.UserDomain;
import com.innovae.model.User;
import com.innovae.service.AccountService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /*@RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("../login.html");
    }*/

    //  鐧诲綍
    @ResponseBody
    @RequestMapping(value = "/login1", method = {RequestMethod.GET, RequestMethod.POST})
    public UserDomain login(User user) throws Exception{
        Gson gson = new Gson();
//        String result = gson.toJson(accountService.UserLogin(user));
//        return result;
        return accountService.UserLogin(user);
    }

//    @ResponseBody
//    @RequestMapping(value = "/login1", method = {RequestMethod.GET, RequestMethod.POST})
//    public String login() throws Exception{
////        return new ModelAndView("login/test.html");
//        return "axs";
//    }
}
