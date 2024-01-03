package com.sickgyun.server.comment.presentation.dto;

import com.sickgyun.server.comment.domain.Comment;

public record CreateCommentRequest(
	String content
) {

	public Comment toEntity() {
		return new Comment(content);
	}
}
