package com.sickgyun.server.core.service.qna;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sickgyun.server.core.presentation.qna.dto.QnAResponse;
import com.sickgyun.server.core.qna.QnA;
import com.sickgyun.server.core.service.qna.implementation.QnAReader;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryQnAService {

	private final QnAReader qnAReader;

	public List<QnAResponse> findAll() {
		return qnAReader.readAll().stream()
			.map(QnAResponse::from)
			.toList();
	}

	public List<QnAResponse> findAllByCategory(String category) {
		return qnAReader.readAllByCategory(category).stream()
			.map(QnAResponse::from)
			.toList();
	}

	public QnAResponse findOne(Long qnAId) {
		QnA qna = qnAReader.read(qnAId);
		return QnAResponse.from(qna);
	}
}
