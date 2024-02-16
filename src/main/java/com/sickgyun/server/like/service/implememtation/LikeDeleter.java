package com.sickgyun.server.like.service.implememtation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.like.domain.Like;
import com.sickgyun.server.like.domain.repository.LikeRepository;
import com.sickgyun.server.qna.domain.QnA;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LikeDeleter {

	private final LikeRepository likeRepository;

	public void delete(Like like) {
		likeRepository.delete(like);
	}

	public void deleteByQnA(QnA qnA) {
		likeRepository.deleteByQnA(qnA);
	}
}
