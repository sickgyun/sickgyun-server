package com.sickgyun.server.like.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sickgyun.server.like.service.CommandLikeService;
import com.sickgyun.server.like.service.QueryLikeService;
import com.sickgyun.server.user.domain.User;
import com.sickgyun.server.user.service.UserTempService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/likes")
public class LikeController {

	private final CommandLikeService commandLikeService;
	private final QueryLikeService queryLikeService;
	private final UserTempService userTempService;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/{qna-id}")
	public void createLike(@PathVariable(name = "qna-id") Long qnAId) {
		User user = userTempService.getUserId1();
		commandLikeService.create(qnAId, user);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{qna-id}")
	public void deleteLike(@PathVariable(name = "qna-id") Long qnAId) {
		User user = userTempService.getUserId1();
		commandLikeService.delete(qnAId, user);
	}

	@GetMapping("/{qna-id}")
	public boolean checkLiked(@PathVariable(name = "qna-id") Long qnAId) {
		User user = userTempService.getUserId1();
		return queryLikeService.checkLike(qnAId, user);
	}
}
