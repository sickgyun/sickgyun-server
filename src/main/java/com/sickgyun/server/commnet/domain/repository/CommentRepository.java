package com.sickgyun.server.commnet.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sickgyun.server.commnet.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
