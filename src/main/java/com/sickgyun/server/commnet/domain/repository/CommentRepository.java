package com.sickgyun.server.commnet.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sickgyun.server.commnet.domain.Comment;
import com.sickgyun.server.qna.QnA;

import jakarta.persistence.EntityNotFoundException;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findByQnA(QnA qnA);

	default Comment getById(Long commentId) {
		return findById(commentId)
			.orElseThrow(() -> new EntityNotFoundException("댓글을 찾을 수 없습니다."));
	}
}
