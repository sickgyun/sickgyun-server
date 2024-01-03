package com.sickgyun.server.commnet.presentation;

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

import com.sickgyun.server.commnet.presentation.dto.CommentResponse;
import com.sickgyun.server.commnet.presentation.dto.CreateCommentRequest;
import com.sickgyun.server.commnet.service.CommandCommentService;
import com.sickgyun.server.commnet.service.QueryCommentService;
import com.sickgyun.server.user.domain.User;
import com.sickgyun.server.user.service.UserTempService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

	private final UserTempService userTempService;
	private final CommandCommentService commandCommentService;
	private final QueryCommentService queryCommentService;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/{qna-id}")
	public void createComment(
		@PathVariable(name = "qna-id") Long qnAId,
		@RequestBody CreateCommentRequest request
	) {
		User writer = userTempService.getUserId1();
		commandCommentService.createComment(qnAId, writer, request.toEntity());
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("/{comment-id}")
	public void updateComment(
		@PathVariable(name = "comment-id") Long commentId,
		@RequestBody CreateCommentRequest request
	) {
		User writer = userTempService.getUserId1();
		commandCommentService.updateComment(commentId, request.toEntity(), writer);
	}

	@GetMapping("/{qna-id}")
	public List<CommentResponse> findByQnA(@PathVariable(name = "qna-id") Long qnAId) {
		return queryCommentService.findByQnA(qnAId).stream()
			.map(comment -> CommentResponse.of(comment, comment.getWriter()))
			.toList();
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{comment-id}")
	public void deleteComment(@PathVariable(name = "comment-id") Long commentId) {
		User writer = userTempService.getUserId1();
		commandCommentService.deleteComment(commentId, writer);
	}
}
