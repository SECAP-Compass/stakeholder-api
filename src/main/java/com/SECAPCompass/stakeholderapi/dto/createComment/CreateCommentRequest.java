package com.SECAPCompass.stakeholderapi.dto.createComment;

import com.SECAPCompass.stakeholderapi.model.Discussion;
import com.SECAPCompass.stakeholderapi.model.Stakeholder;

public record CreateCommentRequest(
        String body,
        Stakeholder stakeholder,
        Discussion discussion
) {
}
