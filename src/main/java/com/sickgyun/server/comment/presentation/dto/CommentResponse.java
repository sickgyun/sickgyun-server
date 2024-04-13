package com.sickgyun.server.comment.presentation.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.sickgyun.server.comment.domain.Comment;
import com.sickgyun.server.user.domain.User;
import com.sickgyun.server.user.presentation.dto.UserResponse;

public record CommentResponse(
	Long id,
	String content,
	LocalDateTime createTime,
	UserResponse userResponse,
	List<CommentResponse> children
) {

	public static CommentResponse of(Comment comment, User user) {
		return new CommentResponse(
			comment.getId(),
			comment.getContent(),
			comment.getCreateTime(),
			UserResponse.from(user),
			comment.getChildren().stream()
				.map(child -> CommentResponse.of(child, child.getWriter()))
				.toList()
		);
	}
}
