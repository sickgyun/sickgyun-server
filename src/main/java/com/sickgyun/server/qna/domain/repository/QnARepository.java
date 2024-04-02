package com.sickgyun.server.qna.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sickgyun.server.qna.domain.QnA;
import com.sickgyun.server.qna.domain.value.Category;

import jakarta.persistence.EntityNotFoundException;

public interface QnARepository extends JpaRepository<QnA, Long> {

	List<QnA> findAllByOrderByIdDesc();

	List<QnA> findAllByOrderByLikeCountDescIdDesc();

	List<QnA> findByCategoryOrderByIdDesc(Category category);

	List<QnA> findByCategoryOrderByLikeCountDescIdDesc(Category category);

	default QnA getById(Long qnAId) {
		return findById(qnAId)
			.orElseThrow(() -> new EntityNotFoundException("QnA를 찾을 수 없습니다."));
	}
}
