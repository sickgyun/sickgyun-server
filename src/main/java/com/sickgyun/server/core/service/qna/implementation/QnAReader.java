package com.sickgyun.server.core.service.qna.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sickgyun.server.core.qna.QnA;
import com.sickgyun.server.core.qna.repository.QnARepository;
import com.sickgyun.server.core.qna.value.Category;

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
