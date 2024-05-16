package com.SECAPCompass.stakeholderapi.service;

import com.SECAPCompass.stakeholderapi.dto.createTopic.CreateTopicRequest;
import com.SECAPCompass.stakeholderapi.model.Topic;
import com.SECAPCompass.stakeholderapi.repository.TopicRepository;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Topic createTopic(CreateTopicRequest createTopicRequest){
        var topic = new Topic(createTopicRequest.body(),createTopicRequest.topicTitle(),createTopicRequest.ownerID(),createTopicRequest.ownerName());
        return topicRepository.save(topic);
    }

    public void updateTopic(){

    }

    public void addDiscussionToTopic(){

    }


}
