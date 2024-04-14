package com.sickgyun.server.like.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sickgyun.server.auth.annotation.LoginRequired;
import com.sickgyun.server.auth.repository.AuthRepository;
import com.sickgyun.server.like.service.CommandLikeService;
import com.sickgyun.server.like.service.QueryLikeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/likes")
public class LikeController {

	private final CommandLikeService commandLikeService;
	private final QueryLikeService queryLikeService;
	private final AuthRepository authRepository;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/{qna-id}")
	@LoginRequired
	public void createLike(@PathVariable(name = "qna-id") Long qnAId) {
		commandLikeService.create(qnAId, authRepository.getCurrentUser());
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{qna-id}")
	@LoginRequired
	public void deleteLike(@PathVariable(name = "qna-id") Long qnAId) {
		commandLikeService.delete(qnAId, authRepository.getCurrentUser());
	}

	@GetMapping("/{qna-id}")
	@LoginRequired
	public boolean checkLiked(@PathVariable(name = "qna-id") Long qnAId) {
		return queryLikeService.checkLike(qnAId, authRepository.getCurrentUser());
	}
}
