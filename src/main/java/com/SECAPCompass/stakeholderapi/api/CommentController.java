package com.SECAPCompass.stakeholderapi.api;

import com.SECAPCompass.stakeholderapi.model.Comment;
import com.SECAPCompass.stakeholderapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/comment")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public int addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }

    @PutMapping(path = {"id"})
    public int updateComment(@PathVariable("id") UUID id, @RequestBody Comment comment){
        return commentService.updateCommentByID(id,comment);
    }

    @DeleteMapping(path = {"id"})
    public int deleteComment(@PathVariable("id") UUID id){
        return commentService.removeComment(id);
    }

    @GetMapping(path = {"id"})
    public Optional<Comment> getCommentByID(@PathVariable("id") UUID id){
        return commentService.getCommentByID(id);
    }

    @GetMapping(path = {"userID"})
    public List<Comment> getCommentsByUserID(@PathVariable("userID") UUID userID){
        return commentService.getCommentsByUserID(userID);
    }

    @GetMapping(path = {"userID,topic"})
    public List<Comment> getCommentsByUserIdAndTopic(@PathVariable("userID") UUID userID, @PathVariable("topic") UUID topicID){
        return commentService.getCommentsByUserIdAndTopic(userID,topicID);
    }
}
