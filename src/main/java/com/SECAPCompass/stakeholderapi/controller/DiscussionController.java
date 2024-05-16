package com.SECAPCompass.stakeholderapi.controller;

import com.SECAPCompass.stakeholderapi.dto.createDiscussion.CreateDiscussionRequest;
import com.SECAPCompass.stakeholderapi.dto.createDiscussion.CreateDiscussionResponse;
import com.SECAPCompass.stakeholderapi.dto.updateDiscussion.UpdateDiscussionRequest;
import com.SECAPCompass.stakeholderapi.dto.updateDiscussion.UpdateDiscussionResponse;
import com.SECAPCompass.stakeholderapi.model.Discussion;
import com.SECAPCompass.stakeholderapi.service.DiscussionService;
import com.SECAPCompass.stakeholderapi.service.StakeholderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/discussion")
public class DiscussionController {

    private final DiscussionService discussionService;

    private final StakeholderService stakeholderService;

    public DiscussionController(DiscussionService discussionService, StakeholderService stakeholderService) {
        this.discussionService = discussionService;
        this.stakeholderService = stakeholderService;
    }

    @PostMapping
    ResponseEntity<CreateDiscussionResponse> createNewDiscussion(@RequestBody CreateDiscussionRequest createDiscussionRequest){
        var owner = stakeholderService.getStakeholderById(createDiscussionRequest.userId());
        var discussion = discussionService.addDiscussion(createDiscussionRequest,owner);
        return new ResponseEntity<>(
                new CreateDiscussionResponse(discussion.getTitle(),discussion.getBody(),discussion.getCreateInstant(),discussion.getId()),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/update/{discussionId}")
    ResponseEntity<UUID> updateDiscussion(@RequestBody UpdateDiscussionRequest updateDiscussionRequest, @PathVariable  UUID discussionId){
        var discussion = discussionService.getDiscussionById(discussionId);
        discussion = discussionService.updateDiscussion(updateDiscussionRequest,discussion);
        return new ResponseEntity<>(discussion.getId(),HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    void removeDiscussion(@PathVariable UUID id){

    }

    @GetMapping("/{id}")
    Discussion getDiscussionById(@PathVariable UUID id){
        return discussionService.getDiscussionById(id);
    }

    @PutMapping("/close{id}")
    void closeDiscussion(@PathVariable UUID id){
        var discussion = discussionService.getDiscussionById(id);
        discussionService.closeDiscussion(discussion);
    }
}
