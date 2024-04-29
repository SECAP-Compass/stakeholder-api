package com.SECAPCompass.stakeholderapi.dto.createDiscussion;

import java.util.UUID;

public record CreateDiscussionRequest(
        String title,
        String body,
        UUID userId
) {
}
