package com.sickgyun.server.qna.presentation.dto;

import com.sickgyun.server.qna.QnA;
import com.sickgyun.server.qna.value.Category;

public record CreateQnARequest(
	String title,
	String content,
	Category category
) {

	public QnA toEntity() {
		return new QnA(title, content, category);
	}
}
