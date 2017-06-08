package com.innovae.controller;

import com.innovae.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Polotin on 2017/6/8.
 */
@CrossOrigin
@RestController
@RequestMapping(value = "forum",method = {RequestMethod.GET, RequestMethod.POST})
public class ForumController {
    @Autowired
    ForumService forumService;

    @ResponseBody
    @RequestMapping(value = "/topics", method = {RequestMethod.GET, RequestMethod.POST})
    public String getTopics(int type, int curNum, int perPage, int isSortByHot, HttpServletRequest request, HttpServletResponse response) throws Exception{
//        System.out.println(forumService.getTopicListJson(type, curNum, perPage, isSortByHot));
        System.out.println(request.getSession().getAttribute("id"));
        return forumService.getTopicListJson(type, curNum, perPage, isSortByHot);
    }
}
