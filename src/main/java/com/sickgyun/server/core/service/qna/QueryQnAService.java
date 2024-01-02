package com.sickgyun.server.core.service.qna;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sickgyun.server.core.qna.QnA;
import com.sickgyun.server.core.service.qna.implementation.QnAReader;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryQnAService {

	private final QnAReader qnAReader;

	public List<QnA> findAllByCategory(String category) {
		if (category.equals("ALL")) {
			return qnAReader.readAll();
		}
		return qnAReader.readAllByCategory(category);
	}

	public QnA findOne(Long qnAId) {
		return qnAReader.read(qnAId);
	}
}
