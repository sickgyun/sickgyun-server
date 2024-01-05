package com.sickgyun.server.like.service.implememtation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.like.domain.repository.LikeRepository;
import com.sickgyun.server.like.exception.AlreadyLikeException;
import com.sickgyun.server.qna.QnA;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LikeValidator {

	private final LikeRepository likeRepository;

	public void shouldBeAlreadyLike(QnA qnA, User user) {
		boolean isExist = likeRepository.existsByQnAAndUser(qnA, user);

		if (isExist) {
			throw new AlreadyLikeException();
		}
	}

	public boolean checkLiked(QnA qnA, User user) {
		return likeRepository.existsByQnAAndUser(qnA, user);
	}
}
