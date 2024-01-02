package com.sickgyun.server.core.qna.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sickgyun.server.core.qna.QnA;
import com.sickgyun.server.core.qna.service.implementation.QnACreator;
import com.sickgyun.server.core.qna.service.implementation.QnADeleter;
import com.sickgyun.server.core.qna.service.implementation.QnAReader;
import com.sickgyun.server.core.qna.service.implementation.QnAUpdater;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandQnAService {

	private final QnACreator qnACreator;
	private final QnAUpdater qnAUpdater;
	private final QnAReader qnAReader;
	private final QnADeleter qnADeleter;

	public void createQnA(QnA qnA) {
		qnACreator.create(qnA);
	}

	public void updateQnA(Long qnAId, QnA qnA) {
		QnA updatableQnA = qnAReader.read(qnAId);
		qnAUpdater.update(updatableQnA, qnA);
	}

	public void deleteQnA(Long qnAId) {
		QnA qnA = qnAReader.read(qnAId);
		qnADeleter.delete(qnA);
	}
}
