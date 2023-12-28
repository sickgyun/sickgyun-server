package com.sickgyun.server.core.presentation.qna.dto;

import com.sickgyun.server.core.qna.QnA;

public record CreateQnARequest (
        String title,
        String content
) {

    public QnA toEntity() {
        return new QnA(title, content);
    }
}
