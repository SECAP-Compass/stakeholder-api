package com.SECAPCompass.stakeholderapi.service;

import com.SECAPCompass.stakeholderapi.dto.createDiscussion.CreateDiscussionRequest;
import com.SECAPCompass.stakeholderapi.dto.updateDiscussion.UpdateDiscussionRequest;
import com.SECAPCompass.stakeholderapi.exception.DiscussionIsClosedException;
import com.SECAPCompass.stakeholderapi.exception.DomainNotFoundException;
import com.SECAPCompass.stakeholderapi.exception.EntityNotFoundException;
import com.SECAPCompass.stakeholderapi.model.Comment;
import com.SECAPCompass.stakeholderapi.model.Discussion;
import com.SECAPCompass.stakeholderapi.model.Stakeholder;
import com.SECAPCompass.stakeholderapi.repository.DiscussionRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class DiscussionService {

    private final DiscussionRepository discussionRepository;

    public DiscussionService(DiscussionRepository discussionRepository) {
        this.discussionRepository = discussionRepository;
    }

    public Discussion addDiscussion(CreateDiscussionRequest createDiscussionRequest, Stakeholder owner){
        var discussion = new Discussion(createDiscussionRequest.title(),createDiscussionRequest.body());
        discussion.setStakeholder(owner);
        return discussionRepository.save(discussion);
    }

    public Discussion updateDiscussion(UpdateDiscussionRequest updateDiscussionRequest){
        var discussion = discussionRepository.findById(updateDiscussionRequest.discussionId())
                .orElseThrow(() -> new DomainNotFoundException("domain.not-found",updateDiscussionRequest.discussionId()));
        if(discussion.isClosed){
            throw new DiscussionIsClosedException("discussion.is-closed",discussion.getId());
        }
        discussion.setTitle(updateDiscussionRequest.title());
        discussion.setBody(updateDiscussionRequest.body());
        discussion.setEdited(true);
        discussion.setEditInstant(Instant.now());
        return discussionRepository.save(discussion);
    }

    public Discussion getDiscussionById(UUID id){
        return discussionRepository.findById(id).orElseThrow(() -> new DomainNotFoundException("domain.not-found",id));
    }

    public void addCommentToDiscussion(Discussion discussion, Comment comment){
        if(discussion == null){
            throw new EntityNotFoundException("entity.not-found",Discussion.class.getName());
        }
        if(discussion.isClosed){
            throw new DiscussionIsClosedException("discussion.is-closed",discussion.getId());
        }
        if(comment == null){
            throw new EntityNotFoundException("entity.not-found",Comment.class.getName());
        }
        discussion.getComments().add(comment);
        discussionRepository.save(discussion);
    }

    public void closeDiscussion(Discussion discussion){
        if(discussion == null){
            throw new EntityNotFoundException("entity.not-found",Discussion.class.getName());
        }
        if(discussion.isClosed){
            throw new RuntimeException();
        }
        discussion.setClosed(true);
        discussionRepository.save(discussion);
    }



}
