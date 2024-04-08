package com.sickgyun.server.comment.presentation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sickgyun.server.auth.annotation.LoginRequired;
import com.sickgyun.server.auth.repository.AuthRepository;
import com.sickgyun.server.comment.presentation.dto.CommentResponse;
import com.sickgyun.server.comment.presentation.dto.CreateCommentRequest;
import com.sickgyun.server.comment.service.CommandCommentService;
import com.sickgyun.server.comment.service.QueryCommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

	private final AuthRepository authRepository;
	private final CommandCommentService commandCommentService;
	private final QueryCommentService queryCommentService;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/{qna-id}")
	@LoginRequired
	public void createComment(
		@PathVariable(name = "qna-id") Long qnAId,
		@RequestBody CreateCommentRequest request
	) {
		commandCommentService.createComment(qnAId, authRepository.getCurrentUser(), request.toEntity());
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("/{comment-id}")
	@LoginRequired
	public void updateComment(
		@PathVariable(name = "comment-id") Long commentId,
		@RequestBody CreateCommentRequest request
	) {
		commandCommentService.updateComment(commentId, request.toEntity(), authRepository.getCurrentUser());
	}

	@GetMapping("/{qna-id}")
	public List<CommentResponse> findByQnA(@PathVariable(name = "qna-id") Long qnAId) {
		return queryCommentService.findByQnA(qnAId).stream()
			.map(comment -> CommentResponse.of(comment, comment.getWriter()))
			.toList();
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{comment-id}")
	@LoginRequired
	public void deleteComment(@PathVariable(name = "comment-id") Long commentId) {
		commandCommentService.deleteComment(commentId, authRepository.getCurrentUser());
	}
}
