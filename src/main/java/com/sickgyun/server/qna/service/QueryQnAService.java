package com.sickgyun.server.qna.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sickgyun.server.qna.domain.QnA;
import com.sickgyun.server.qna.service.implementation.QnAReader;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryQnAService {

	private final QnAReader qnAReader;

	public List<QnA> findAllByCategory(String category, String criteria) {
		if (category.equals("ALL")) {
			if (criteria.equals("like")) {
				return qnAReader.readAllOrderByLike();
			}
			return qnAReader.readAll();
		}

		if (criteria.equals("like")) {
			return qnAReader.readAllByCategoryOrderByLike(category);
		}
		return qnAReader.readAllByCategory(category);
	}

	public QnA findOne(Long qnAId) {
		return qnAReader.read(qnAId);
	}
}
