package com.SECAPCompass.stakeholderapi.service;

import com.SECAPCompass.stakeholderapi.dto.createComment.CreateCommentRequest;
import com.SECAPCompass.stakeholderapi.dto.updateComment.UpdateCommentRequest;
import com.SECAPCompass.stakeholderapi.exception.DiscussionIsClosedException;
import com.SECAPCompass.stakeholderapi.exception.DomainNotFoundException;
import com.SECAPCompass.stakeholderapi.exception.EntityNotFoundException;
import com.SECAPCompass.stakeholderapi.model.Comment;
import com.SECAPCompass.stakeholderapi.repository.CommentRepository;
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
        if(comment == null){
            throw new EntityNotFoundException("entity.not-found",Comment.class.getName());
        }
        if(comment.getDiscussion().isClosed){
            throw new DiscussionIsClosedException("discussion.is-closed",comment.getDiscussion().getId());
        }
        comment.setBody("Comment Removed");
        comment.setRemoved(true);
        comment.setRemoveInstant(Instant.now());
        commentRepository.save(comment);
    }

    public void updateComment(UpdateCommentRequest updateCommentRequest){
        var comment = commentRepository.findById(updateCommentRequest.commentId()).orElseThrow(()-> new DomainNotFoundException("domain.not-found",updateCommentRequest.commentId()));
        if(comment.getDiscussion().isClosed){
            throw new DiscussionIsClosedException("discussion.is-closed",comment.getDiscussion().getId());
        }
        comment.setBody(updateCommentRequest.body());
        comment.setEditInstant(Instant.now());
        comment.setEdited(true);
        commentRepository.save(comment);
    }
}
