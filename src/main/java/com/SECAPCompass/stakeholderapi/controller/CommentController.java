package com.SECAPCompass.stakeholderapi.controller;

import com.SECAPCompass.stakeholderapi.dto.createComment.CreateCommentRequest;
import com.SECAPCompass.stakeholderapi.dto.createComment.CreateCommentResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @PostMapping
    CreateCommentResponse createComment(@RequestBody CreateCommentRequest createCommentRequest){

        return new CreateCommentResponse();
    }
}
