package com.innovae.controller;

import com.innovae.model.Comment;
import com.innovae.model.Topic;
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


    /**
     * by manson
     * @param topic
     * @param request
     * @param response
     * @return IsSuccess
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/addTopic",method = {RequestMethod.GET,RequestMethod.POST})
    public boolean addTopic(Topic topic,HttpServletRequest request,HttpServletResponse response)throws Exception
    {
        topic.setUserId(request.getSession().getAttribute("id").toString());
        topic.setUserName(request.getSession().getAttribute("name").toString());
        response.sendRedirect("/forum");
        return forumService.addTopic(topic);
    }

    @ResponseBody
    @RequestMapping(value = "/addComment",method = {RequestMethod.GET,RequestMethod.POST})
    public boolean addComment(Comment comment,HttpServletRequest request,HttpServletResponse response) throws Exception
    {
        //int TopicId
        int temp = 0;
        comment.setTopicId(temp);
        comment.setUserId(request.getSession().getAttribute("id").toString());
        //after add a comment
        response.setHeader("refresh","1");
        return forumService.addComment(comment);
    }
    @ResponseBody
    @RequestMapping(value = "/viewTopic",method ={RequestMethod.GET,RequestMethod.POST})
    public String getCommentsList(int topicId,int page, HttpServletRequest request,HttpServletResponse response)
    {
        return forumService.getCommentListJson(topicId,page);
    }
}
