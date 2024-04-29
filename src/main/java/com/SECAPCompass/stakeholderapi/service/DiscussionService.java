package com.SECAPCompass.stakeholderapi.service;

import com.SECAPCompass.stakeholderapi.dto.createDiscussion.CreateDiscussionRequest;
import com.SECAPCompass.stakeholderapi.dto.updateDiscussion.UpdateDiscussionRequest;
import com.SECAPCompass.stakeholderapi.model.Comment;
import com.SECAPCompass.stakeholderapi.model.Discussion;
import com.SECAPCompass.stakeholderapi.model.Stakeholder;
import com.SECAPCompass.stakeholderapi.repository.DiscussionRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Service
public class DiscussionService {

    private final DiscussionRepository discussionRepository;

    public DiscussionService(DiscussionRepository discussionRepository) {
        this.discussionRepository = discussionRepository;
    }

    public Discussion addDiscussion(CreateDiscussionRequest createDiscussionRequest, Stakeholder owner){
        var discussion = new Discussion(createDiscussionRequest.title(),createDiscussionRequest.body(), Instant.now());
        discussion.setStakeholder(owner);
        return discussionRepository.save(discussion);
    }

    public Discussion updateDiscussion(UpdateDiscussionRequest updateDiscussionRequest){
        var discussion = discussionRepository.findById(updateDiscussionRequest.discussionId()).orElseThrow(RuntimeException::new);
        discussion.setTitle(updateDiscussionRequest.title());
        discussion.setBody(updateDiscussionRequest.body());
        discussion.setEdited(true);
        discussion.setEditDate(Instant.now());
        return discussionRepository.save(discussion);
    }

    public Discussion getDiscussionById(UUID id){
        return discussionRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void addCommentToDiscussion(Discussion discussion, Comment comment){
        discussion.getComments().add(comment);
        discussionRepository.save(discussion);
    }

    public void closeDiscussion(Discussion discussion){
        discussion.setClosed(true);
        discussionRepository.save(discussion);
    }


}
