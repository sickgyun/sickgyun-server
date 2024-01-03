package com.sickgyun.server.qna.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.qna.QnA;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QnAUpdater {

	public void update(QnA updatableQnA, QnA qnA) {
		updatableQnA.update(qnA);
	}
}
