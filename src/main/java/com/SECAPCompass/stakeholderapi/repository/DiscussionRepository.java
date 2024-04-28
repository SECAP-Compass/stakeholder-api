package com.SECAPCompass.stakeholderapi.repository;

import com.SECAPCompass.stakeholderapi.model.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DiscussionRepository extends JpaRepository<Discussion, UUID> {
}
