package com.SECAPCompass.stakeholderapi.dto.updateComment;

import java.util.UUID;

public record UpdateCommentRequest(
        UUID commentId,
        String body
) {
}
