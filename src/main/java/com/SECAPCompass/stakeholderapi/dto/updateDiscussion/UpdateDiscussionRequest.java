package com.SECAPCompass.stakeholderapi.dto.updateDiscussion;

import java.util.UUID;

public record UpdateDiscussionRequest(
        String title,
        String body
) {
}
