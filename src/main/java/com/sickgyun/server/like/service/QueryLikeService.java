package com.sickgyun.server.like.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sickgyun.server.like.service.implememtation.LikeValidator;
import com.sickgyun.server.qna.domain.QnA;
import com.sickgyun.server.qna.service.implementation.QnAReader;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryLikeService {

	private final QnAReader qnAReader;
	private final LikeValidator likeValidator;

	public boolean checkLike(Long qnAId, User user) {
		QnA qnA = qnAReader.read(qnAId);
		return likeValidator.checkLiked(qnA, user);
	}
}
