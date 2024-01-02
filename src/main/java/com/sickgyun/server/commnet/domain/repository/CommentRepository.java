package com.sickgyun.server.commnet.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sickgyun.server.commnet.domain.Comment;

import jakarta.persistence.EntityNotFoundException;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	default Comment getById(Long commentId) {
		return findById(commentId)
			.orElseThrow(() -> new EntityNotFoundException("댓글을 찾을 수 없습니다."));
	}
}
