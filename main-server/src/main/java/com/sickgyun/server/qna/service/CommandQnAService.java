package com.sickgyun.server.qna.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sickgyun.server.comment.service.implementation.CommentDeleter;
import com.sickgyun.server.like.service.implememtation.LikeDeleter;
import com.sickgyun.server.qna.domain.QnA;
import com.sickgyun.server.qna.service.implementation.QnACreator;
import com.sickgyun.server.qna.service.implementation.QnADeleter;
import com.sickgyun.server.qna.service.implementation.QnAReader;
import com.sickgyun.server.qna.service.implementation.QnAUpdater;
import com.sickgyun.server.qna.service.implementation.QnAValidator;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandQnAService {

	private final QnACreator qnACreator;
	private final QnAUpdater qnAUpdater;
	private final QnAReader qnAReader;
	private final QnADeleter qnADeleter;
	private final QnAValidator qnAValidator;
	private final CommentDeleter commentDeleter;
	private final LikeDeleter likeDeleter;

	public void createQnA(QnA qnA, User user) {
		qnACreator.create(qnA, user);
	}

	public void updateQnA(Long qnAId, QnA qnA, User user) {
		QnA updatableQnA = qnAReader.read(qnAId);
		qnAValidator.shouldBeSameUser(updatableQnA.getWriter(), user);
		qnAUpdater.update(updatableQnA, qnA);
	}

	public void deleteQnA(Long qnAId, User user) {
		QnA qnA = qnAReader.read(qnAId);
		qnAValidator.shouldBeSameUser(qnA.getWriter(), user);
		qnADeleter.delete(qnA);
		commentDeleter.deleteByQnA(qnA);
		likeDeleter.deleteByQnA(qnA);
	}
}
