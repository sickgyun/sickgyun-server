package com.sickgyun.server.like.service.implememtation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.like.domain.Like;
import com.sickgyun.server.like.domain.repository.LikeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LikeDeleter {

	private final LikeRepository likeRepository;

	public void delete(Like like) {
		likeRepository.delete(like);
	}
}
