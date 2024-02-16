package com.sickgyun.server.qna.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sickgyun.server.qna.domain.QnA;
import com.sickgyun.server.qna.domain.repository.QnARepository;
import com.sickgyun.server.qna.domain.value.Category;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QnAReader {

	private final QnARepository qnARepository;

	public List<QnA> readAll() {
		return qnARepository.findAllByOrderByIdDesc();
	}

	public List<QnA> readAllByCategory(String category) {
		return qnARepository.findByCategoryOrderByIdDesc(Category.valueOf(category));
	}

	public QnA read(Long qnAId) {
		return qnARepository.getById(qnAId);
	}
}
