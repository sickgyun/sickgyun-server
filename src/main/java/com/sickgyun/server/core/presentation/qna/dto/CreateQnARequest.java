package com.sickgyun.server.core.presentation.qna.dto;

import com.sickgyun.server.core.qna.QnA;
import com.sickgyun.server.core.qna.value.Category;

public record CreateQnARequest (
        String title,
        String content,
        Category category
) {

    public QnA toEntity() {
        return new QnA(title, content, category);
    }
}
