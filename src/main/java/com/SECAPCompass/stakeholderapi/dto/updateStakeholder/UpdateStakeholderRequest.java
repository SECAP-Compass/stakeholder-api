package com.SECAPCompass.stakeholderapi.dto.updateStakeholder;

import java.util.UUID;

public record UpdateStakeholderRequest(
        String name,
        String surname,
        String city,
        UUID userId
) {
}
