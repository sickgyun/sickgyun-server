package com.sickgyun.server.core.service.qna;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sickgyun.server.core.presentation.qna.dto.CreateQnARequest;
import com.sickgyun.server.core.qna.QnA;
import com.sickgyun.server.core.service.qna.implementation.QnACreator;
import com.sickgyun.server.core.service.qna.implementation.QnADeleter;
import com.sickgyun.server.core.service.qna.implementation.QnAReader;
import com.sickgyun.server.core.service.qna.implementation.QnAUpdater;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandQnAService {

	private final QnACreator qnACreator;
	private final QnAUpdater qnAUpdater;
	private final QnAReader qnAReader;
	private final QnADeleter qnADeleter;

	public void createQnA(CreateQnARequest request) {
		qnACreator.save(request.toEntity());
	}

	public void updateQnA(Long qnAId, CreateQnARequest request) {
		QnA qnA = qnAReader.read(qnAId);
		qnAUpdater.update(qnA, request);
	}

	public void deleteQnA(Long qnAId) {
		QnA qnA = qnAReader.read(qnAId);
		qnADeleter.delete(qnA);
	}
}
