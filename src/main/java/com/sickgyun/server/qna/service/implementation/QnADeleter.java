package com.sickgyun.server.qna.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.qna.domain.QnA;
import com.sickgyun.server.qna.domain.repository.QnARepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QnADeleter {

	private final QnARepository qnARepository;

	public void delete(QnA qnA) {
		qnARepository.delete(qnA);
	}
}
