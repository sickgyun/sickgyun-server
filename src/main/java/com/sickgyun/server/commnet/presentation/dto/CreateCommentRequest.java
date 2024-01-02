package com.sickgyun.server.commnet.presentation.dto;

import com.sickgyun.server.commnet.domain.Comment;

public record CreateCommentRequest(
	String content
) {

	public Comment toEntity() {
		return new Comment(content);
	}
}
