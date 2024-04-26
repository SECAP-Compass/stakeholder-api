package com.SECAPCompass.stakeholderapi.service;

import com.SECAPCompass.stakeholderapi.repository.TopicRepository;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }
}
