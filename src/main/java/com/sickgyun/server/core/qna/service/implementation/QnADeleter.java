package com.sickgyun.server.core.qna.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.core.qna.QnA;
import com.sickgyun.server.core.qna.repository.QnARepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QnADeleter {

	private final QnARepository qnARepository;

	public void delete(QnA qnA) {
		qnARepository.delete(qnA);
	}
}
