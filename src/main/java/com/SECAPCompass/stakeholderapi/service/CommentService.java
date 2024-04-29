package com.SECAPCompass.stakeholderapi.service;

import com.SECAPCompass.stakeholderapi.dto.createComment.CreateCommentRequest;
import com.SECAPCompass.stakeholderapi.dto.updateComment.UpdateCommentRequest;
import com.SECAPCompass.stakeholderapi.model.Comment;
import com.SECAPCompass.stakeholderapi.repository.CommentRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment addComment(CreateCommentRequest createCommentRequest){
        var comment = new Comment(createCommentRequest.body(),createCommentRequest.stakeholder(),createCommentRequest.discussion());
        return commentRepository.save(comment);
    }
    public void markCommentAsRemoved(Comment comment){
        if(comment.getDiscussion().isClosed){
            throw new RuntimeException();
        }
        comment.setBody("Comment Removed");
        comment.setRemoved(true);
        comment.setRemoveInstant(Instant.now());
        commentRepository.save(comment);
    }

    public void updateComment(UpdateCommentRequest updateCommentRequest){
        var comment = commentRepository.findById(updateCommentRequest.commentId()).orElseThrow(RuntimeException::new);
        if(comment.getDiscussion().isClosed){
            throw new RuntimeException();
        }
        comment.setBody(updateCommentRequest.body());
        comment.setEditInstant(Instant.now());
        comment.setEdited(true);
        commentRepository.save(comment);
    }
}
