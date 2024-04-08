package com.sickgyun.server.qna.presentation.dto;

import java.time.LocalDateTime;

import com.sickgyun.server.qna.domain.QnA;
import com.sickgyun.server.qna.domain.value.Category;
import com.sickgyun.server.user.presentation.dto.UserResponse;

public record QnAResponse(
	Long id,
	String title,
	String content,
	Category category,
	LocalDateTime createTime,
	Long likeCount,
	Long commentCount,
	UserResponse writer
) {

	public static QnAResponse from(QnA qnA) {
		return new QnAResponse(
			qnA.getId(),
			qnA.getTitle(),
			qnA.getContent(),
			qnA.getCategory(),
			qnA.getCreateTime(),
			qnA.getLikeCount(),
			qnA.getCommentCount(),
			UserResponse.from(qnA.getWriter())
		);
	}
}
