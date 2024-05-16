package com.SECAPCompass.stakeholderapi.repository;

import com.SECAPCompass.stakeholderapi.model.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DiscussionRepository extends JpaRepository<Discussion, UUID> {
    List<Discussion> findByTitleContainingIgnoreCase(String keyword);
}
