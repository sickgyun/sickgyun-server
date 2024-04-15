package com.sickgyun.server.qna.presentation.dto;

import com.sickgyun.server.qna.domain.QnA;
import com.sickgyun.server.qna.domain.value.Category;

public record CreateQnARequest(
	String title,
	String content,
	Category category
) {

	public QnA toEntity() {
		return new QnA(title, content, category);
	}
}
