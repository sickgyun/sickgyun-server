package com.sickgyun.server.qna.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.qna.domain.QnA;
import com.sickgyun.server.qna.domain.repository.QnARepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QnACreator {

	private final QnARepository qnARepository;

	public void create(QnA qnA) {
		qnARepository.save(qnA);
	}
}
