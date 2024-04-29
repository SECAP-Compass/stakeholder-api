package com.SECAPCompass.stakeholderapi.repository;

import com.SECAPCompass.stakeholderapi.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
}
