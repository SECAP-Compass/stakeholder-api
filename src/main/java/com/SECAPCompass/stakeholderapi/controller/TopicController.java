package com.SECAPCompass.stakeholderapi.controller;

import com.SECAPCompass.stakeholderapi.dto.createTopic.CreateTopicRequest;
import com.SECAPCompass.stakeholderapi.dto.createTopic.CreateTopicResponse;
import com.SECAPCompass.stakeholderapi.service.TopicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topic")
public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @PostMapping
    public ResponseEntity<CreateTopicResponse> createTopic(CreateTopicRequest createTopicRequest){
        var topic = topicService.createTopic(createTopicRequest);
        return new ResponseEntity<>(new CreateTopicResponse(topic.getId()), HttpStatus.CREATED);
    }

    public void addTopicToDiscussion(){

    }
}
