package com.SECAPCompass.stakeholderapi.repository;

import com.SECAPCompass.stakeholderapi.model.Stakeholder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StakeholderRepository extends JpaRepository<Stakeholder, UUID> {
    Optional<Stakeholder> findByUserName(String userName);
}
