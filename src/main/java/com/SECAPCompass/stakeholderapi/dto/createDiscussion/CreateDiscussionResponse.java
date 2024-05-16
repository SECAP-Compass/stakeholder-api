package com.SECAPCompass.stakeholderapi.dto.createDiscussion;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public record CreateDiscussionResponse(
        String title,
        String body,
        Instant instant,
        UUID id
) {
}
