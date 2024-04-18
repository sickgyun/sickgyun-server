package com.sickgyun.server.like.service.implememtation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.like.domain.Like;
import com.sickgyun.server.like.domain.repository.LikeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LikeCreator {

	private final LikeRepository likeRepository;

	public void create(Like like) {
		likeRepository.save(like);
	}
}
