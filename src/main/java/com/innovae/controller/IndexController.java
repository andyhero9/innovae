package com.innovae.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 张志强
 * @version v0.1 2017/6/4.
 */
@RestController

public class IndexController {
    @RequestMapping(value = "/login")
    ModelAndView login()
    {
        return new ModelAndView("webContent/login/login.html");
    }

    @RequestMapping(value = "/forum")
    ModelAndView forum(){
        return new ModelAndView("webContent/forum/portfolio.html");
    }


    @RequestMapping(value = "/topic")
    ModelAndView topic(){
        return new ModelAndView("webContent/topic/index.html");
    }
}
