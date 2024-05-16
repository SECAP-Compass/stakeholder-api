package com.SECAPCompass.stakeholderapi.controller;

import com.SECAPCompass.stakeholderapi.dto.createComment.CreateCommentRequest;
import com.SECAPCompass.stakeholderapi.dto.createComment.CreateCommentResponse;
import com.SECAPCompass.stakeholderapi.dto.updateComment.UpdateCommentRequest;
import com.SECAPCompass.stakeholderapi.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/comment")
public class CommentController {


    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CreateCommentResponse> createComment(@RequestBody CreateCommentRequest createCommentRequest){
        var comment = commentService.addComment(createCommentRequest);
        return new ResponseEntity<>(new CreateCommentResponse(comment.getId()), HttpStatus.CREATED);
    }

    @PutMapping("/update/{commentId}")
    public ResponseEntity<UUID> updateComment(@RequestBody UpdateCommentRequest updateCommentRequest
            , @PathVariable UUID commentId){
        var comment = commentService.getCommentById(commentId);
        return new ResponseEntity<>(comment.getId(),HttpStatus.OK);
    }
}
