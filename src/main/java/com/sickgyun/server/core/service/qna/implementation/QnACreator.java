package com.sickgyun.server.core.service.qna.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.core.qna.QnA;
import com.sickgyun.server.core.qna.repository.QnARepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QnACreator {

	private final QnARepository qnARepository;

	public void create(QnA qnA) {
		qnARepository.save(qnA);
	}
}
