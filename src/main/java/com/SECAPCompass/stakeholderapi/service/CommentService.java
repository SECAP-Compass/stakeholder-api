package com.SECAPCompass.stakeholderapi.service;

import com.SECAPCompass.stakeholderapi.dao.CommentDao;
import com.SECAPCompass.stakeholderapi.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommentService {

    private final CommentDao commentDao;

    @Autowired
    public CommentService(@Qualifier("COMMENT") CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public int addComment(Comment comment){
        return commentDao.insertComment(comment);
    }

    public int removeComment(UUID id){
        return commentDao.deleteCommentByID(id);
    }

    public int updateCommentByID(UUID id, Comment comment){
        return commentDao.updateCommentByID(id,comment);
    }

    public Optional<Comment> getCommentByID(UUID id){
        return commentDao.selectCommentByID(id);
    }

    public List<Comment> getCommentsByUserID(UUID userID){
        return commentDao.selectCommentsByUserID(userID);
    }

    public List<Comment> getCommentsByUserIdAndTopic(UUID userID, UUID topicID){
        return commentDao.selectCommentsByUserIdAndTopic(userID,topicID);
    }
}
