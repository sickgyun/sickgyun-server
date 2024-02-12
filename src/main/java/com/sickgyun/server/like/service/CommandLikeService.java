package com.sickgyun.server.like.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sickgyun.server.like.domain.Like;
import com.sickgyun.server.like.service.implememtation.LikeCreator;
import com.sickgyun.server.like.service.implememtation.LikeDeleter;
import com.sickgyun.server.like.service.implememtation.LikeReader;
import com.sickgyun.server.like.service.implememtation.LikeValidator;
import com.sickgyun.server.qna.domain.QnA;
import com.sickgyun.server.qna.service.implementation.QnAReader;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandLikeService {

	private final LikeCreator likeCreator;
	private final LikeReader likeReader;
	private final LikeDeleter likeDeleter;
	private final LikeValidator likeValidator;
	private final QnAReader qnAReader;

	public void create(Long qnAId, User user) {
		QnA qnA = qnAReader.read(qnAId);
		likeValidator.shouldNotExistLike(qnA, user);
		likeCreator.create(new Like(user, qnA));
	}

	public void delete(Long qnAId, User user) {
		QnA qnA = qnAReader.read(qnAId);
		Like like = likeReader.read(qnA, user);
		likeDeleter.delete(like);
	}
}
