package com.SECAPCompass.stakeholderapi.dao;

import com.SECAPCompass.stakeholderapi.model.Comment;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommentDao {

    int insertComment(UUID id, Comment comment);

    default int insertComment(Comment comment){
        UUID id = UUID.randomUUID();
        return insertComment(id,comment);
    }

    Optional<Comment> selectCommentByID(UUID id);

    int deleteCommentByID(UUID id);

    int updateCommentByID(UUID id,Comment comment);

    List<Comment> selectCommentsByUserID(UUID userID);

    List<Comment> selectCommentsByUserIdAndTopic(UUID userID, UUID topicID);
}
