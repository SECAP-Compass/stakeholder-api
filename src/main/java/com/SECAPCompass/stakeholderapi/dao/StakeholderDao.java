package com.SECAPCompass.stakeholderapi.dao;

import com.SECAPCompass.stakeholderapi.model.Stakeholder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StakeholderDao {

    int insertStakeholder(UUID id, Stakeholder stakeholder);

    default int insertStakeholder(Stakeholder stakeholder){
        UUID id = UUID.randomUUID();
        return insertStakeholder(id,stakeholder);
    }

    List<Stakeholder> selectAllStakeholders();

    Optional<Stakeholder> selectPersonByID(UUID id);

    int deleteStakeholderByID(UUID id);

    int updateStakeholderByID(UUID id,Stakeholder stakeholder);
}
