package com.innovae.service;

import com.innovae.model.Comment;
import org.springframework.stereotype.Service;

/**
 * Created by manson on 2017/6/8.
 */

@Service
public interface CommentService {

    boolean addComment(Comment comment) throws Exception;
    String getCommentListJson(int topicId,int page);

}
