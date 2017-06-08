package com.innovae.service.imp;

import com.google.gson.Gson;
import com.innovae.model.Comment;
import com.innovae.repository.CommentRepository;
import com.innovae.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by manson on 2017/6/8.
 */
@Service
public class CommentServiceImp implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public boolean addComment(Comment comment) throws Exception
    {
        try {
            commentRepository.save(comment);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return (commentRepository.findById(comment.getId())!=null);
    }

    @Override
    public String getCommentListJson(int topicId,int page)
    {
        List<Comment> comments = commentRepository.getCommentsByTopicId(topicId, page);
        String result = "";
        if (comments.size()!=0)
            result = new Gson().toJson(comments);
        return result;
    }



}
