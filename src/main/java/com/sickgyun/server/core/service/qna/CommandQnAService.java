package com.sickgyun.server.core.service.qna;

import com.sickgyun.server.core.presentation.qna.dto.CreateQnARequest;
import com.sickgyun.server.core.qna.QnA;
import com.sickgyun.server.core.service.qna.implementation.QnACreator;
import com.sickgyun.server.core.service.qna.implementation.QnAReader;
import com.sickgyun.server.core.service.qna.implementation.QnAUpdater;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandQnAService {

    private final QnACreator qnACreator;
    private final QnAUpdater qnAUpdater;
    private final QnAReader qnAReader;

    public void createQnA(CreateQnARequest request) {
        qnACreator.save(request.toEntity());
    }

    public void updateQnA(Long qnAId, CreateQnARequest request) {
        QnA qnA = qnAReader.read(qnAId);
        qnAUpdater.update(qnA, request);
    }
}
