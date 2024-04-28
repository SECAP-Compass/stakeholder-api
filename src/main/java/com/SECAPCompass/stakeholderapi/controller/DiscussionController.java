package com.SECAPCompass.stakeholderapi.controller;

import com.SECAPCompass.stakeholderapi.dto.createDiscussion.DiscussionCreateRequest;
import com.SECAPCompass.stakeholderapi.dto.createDiscussion.DiscussionCreateResponse;
import com.SECAPCompass.stakeholderapi.dto.updateDiscussion.UpdateDiscussionRequest;
import com.SECAPCompass.stakeholderapi.dto.updateDiscussion.UpdateDiscussionResponse;
import com.SECAPCompass.stakeholderapi.model.Discussion;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/discussion")
public class DiscussionController {

    @PostMapping
    DiscussionCreateResponse createNewDiscussion(@RequestBody DiscussionCreateRequest discussionCreateRequest){
        return null;
    }

    @PutMapping
    UpdateDiscussionResponse updateDiscussion(@RequestBody UpdateDiscussionRequest updateDiscussionRequest){
        return null;
    }

    @DeleteMapping("/remove/{id}")
    void removeDiscussion(@PathVariable UUID id){

    }

    @GetMapping("/{id}")
    Discussion getDiscussionById(@PathVariable UUID id){
        return null;
    }
}
