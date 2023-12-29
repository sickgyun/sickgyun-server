package com.sickgyun.server.core.service.qna.implementation;

import com.sickgyun.server.core.presentation.qna.dto.CreateQnARequest;
import com.sickgyun.server.core.qna.QnA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QnAUpdater {

    public void update(QnA qnA, CreateQnARequest request) {
        qnA.update(request);
    }
}
