package com.sickgyun.server.core.presentation.qna.dto;

import com.sickgyun.server.core.qna.QnA;

public record QnAResponse (
        Long id,
        String title,
        String content
) {

    public static QnAResponse from(QnA qnA) {
        return new QnAResponse(qnA.getId(), qnA.getTitle(), qnA.getContent());
    }
}
