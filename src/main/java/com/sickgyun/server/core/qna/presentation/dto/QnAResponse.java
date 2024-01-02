package com.sickgyun.server.core.qna.presentation.dto;

import java.time.LocalDateTime;

import com.sickgyun.server.core.qna.QnA;
import com.sickgyun.server.core.qna.value.Category;

public record QnAResponse(
	Long id,
	String title,
	String content,
	Category category,
	LocalDateTime createTime
) {

	public static QnAResponse from(QnA qnA) {
		return new QnAResponse(qnA.getId(), qnA.getTitle(), qnA.getContent(), qnA.getCategory(), qnA.getCreateTime());
	}
}
