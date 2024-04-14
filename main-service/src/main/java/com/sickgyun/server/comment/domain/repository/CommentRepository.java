package com.sickgyun.server.comment.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sickgyun.server.comment.domain.Comment;
import com.sickgyun.server.qna.domain.QnA;

import jakarta.persistence.EntityNotFoundException;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	void deleteByQnA(QnA qnA);

	default Comment getById(Long commentId) {
		return findById(commentId)
			.orElseThrow(() -> new EntityNotFoundException("댓글을 찾을 수 없습니다."));
	}
}
