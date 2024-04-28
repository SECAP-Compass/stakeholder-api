package com.SECAPCompass.stakeholderapi.dto.error;

public record ErrorResponse (
        String message,
        int code,
        String exception
) {
}
