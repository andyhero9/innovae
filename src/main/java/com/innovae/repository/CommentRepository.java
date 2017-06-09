package com.innovae.repository;

import com.innovae.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by manson on 2017/6/5.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer>{
    @Query("select c from Comment c where c.topicId = ?1")
    List<Comment> findByTopicId(int topicId);

    @Query("select c from Comment c where c.id = ?1")
    Comment findById(int id);

    @Query(value = "select c from Comment where topicId=?1 order by time asc limit 10*(page-1),10")
    List<Comment> getCommentsByTopicId(int topicId,int page);
}
