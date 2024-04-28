package com.SECAPCompass.stakeholderapi.dto.createStakeholder;

public record CreateStakeholderRequest(
        String userName,
        String eMail,
        String name,
        String surname,
        String city
) {
}
