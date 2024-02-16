package com.sickgyun.server.like.service.implememtation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.like.domain.Like;
import com.sickgyun.server.like.domain.repository.LikeRepository;
import com.sickgyun.server.qna.domain.QnA;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LikeReader {

	private final LikeRepository likeRepository;

	public Like read(QnA qnA, User user) {
		return likeRepository.getLike(qnA, user);
	}
}
