package com.SECAPCompass.stakeholderapi.controller;

import com.SECAPCompass.stakeholderapi.dto.createDiscussion.CreateDiscussionRequest;
import com.SECAPCompass.stakeholderapi.dto.createDiscussion.CreateDiscussionResponse;
import com.SECAPCompass.stakeholderapi.dto.updateDiscussion.UpdateDiscussionRequest;
import com.SECAPCompass.stakeholderapi.dto.updateDiscussion.UpdateDiscussionResponse;
import com.SECAPCompass.stakeholderapi.model.Discussion;
import com.SECAPCompass.stakeholderapi.service.DiscussionService;
import com.SECAPCompass.stakeholderapi.service.StakeholderService;
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
    CreateDiscussionResponse createNewDiscussion(@RequestBody CreateDiscussionRequest createDiscussionRequest){
        var owner = stakeholderService.getStakeholderById(createDiscussionRequest.userId());
        var discussion = discussionService.addDiscussion(createDiscussionRequest,owner);
        return new CreateDiscussionResponse(discussion.getTitle(),discussion.getBody(),discussion.getInstant(),discussion.getId());
    }

    @PutMapping
    UpdateDiscussionResponse updateDiscussion(@RequestBody UpdateDiscussionRequest updateDiscussionRequest){
        var discussion = discussionService.updateDiscussion(updateDiscussionRequest);
        return new UpdateDiscussionResponse();
    }

    @DeleteMapping("/remove/{id}")
    void removeDiscussion(@PathVariable UUID id){

    }

    @GetMapping("/{id}")
    Discussion getDiscussionById(@PathVariable UUID id){
        return discussionService.getDiscussionById(id);
    }
}
