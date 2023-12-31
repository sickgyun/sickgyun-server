package com.sickgyun.server.core.service.qna.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.core.presentation.qna.dto.CreateQnARequest;
import com.sickgyun.server.core.qna.QnA;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QnAUpdater {

	public void update(QnA qnA, CreateQnARequest request) {
		qnA.update(request);
	}
}
