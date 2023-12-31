package com.sickgyun.server.comment.presentation.dto;

import com.sickgyun.server.comment.domain.Comment;
import com.sickgyun.server.user.domain.User;
import com.sickgyun.server.user.presentation.dto.UserResponse;

public record CommentResponse(
	Long id,
	String content,
	UserResponse userResponse
) {

	public static CommentResponse of(Comment comment, User user) {
		return new CommentResponse(comment.getId(), comment.getContent(), UserResponse.from(user));
	}
}
