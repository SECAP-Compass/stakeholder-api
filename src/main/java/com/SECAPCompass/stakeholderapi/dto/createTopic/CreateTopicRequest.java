package com.SECAPCompass.stakeholderapi.dto.createTopic;

import java.util.UUID;

public record CreateTopicRequest(
        String body,
        String topicTitle,
        UUID ownerID,
        String ownerName,
        String city
) {
}
