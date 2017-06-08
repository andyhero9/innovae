package com.innovae.controller;

import com.innovae.model.Comment;
import com.innovae.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by manson on 2017/6/6.
 */

@RestController
public class CommentController {

    private static Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "addComment",method = {RequestMethod.GET,RequestMethod.POST})
    public boolean addComment(Comment comment,HttpServletRequest request,HttpServletResponse response) throws Exception
    {
        //int TopicId
        int temp = 0;
        comment.setTopicId(temp);
        comment.setUserId(request.getSession().getAttribute("id").toString());
        //after add a comment
        response.setHeader("refresh","1");
        return commentService.addComment(comment);
    }
    @ResponseBody
    @RequestMapping(value = "viewTopic",method ={RequestMethod.GET,RequestMethod.POST})
    public String getCommentsList(int topicId,int page, HttpServletRequest request,HttpServletResponse response)
    {
        return commentService.getCommentListJson(topicId,page);
    }
}
