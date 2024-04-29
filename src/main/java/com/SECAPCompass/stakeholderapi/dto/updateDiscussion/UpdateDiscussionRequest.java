package com.SECAPCompass.stakeholderapi.dto.updateDiscussion;

import java.util.UUID;

public record UpdateDiscussionRequest(
        UUID discussionId,
        String title,
        String body
) {
}
