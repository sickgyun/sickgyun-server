package com.sickgyun.server.qna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sickgyun.server.qna.QnA;
import com.sickgyun.server.qna.value.Category;

import jakarta.persistence.EntityNotFoundException;

public interface QnARepository extends JpaRepository<QnA, Long> {

	List<QnA> findAllByOrderByIdDesc();

	List<QnA> findByCategoryOrderByIdDesc(Category category);

	default QnA getById(Long qnAId) {
		return findById(qnAId)
			.orElseThrow(() -> new EntityNotFoundException("QnA를 찾을 수 없습니다."));
	}
}
