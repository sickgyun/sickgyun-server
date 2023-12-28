package com.sickgyun.server.core.service.qna;

import com.sickgyun.server.core.presentation.qna.dto.CreateQnARequest;
import com.sickgyun.server.core.service.qna.implementation.QnACreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandQnAService {

    private final QnACreator qnACreator;

    public void createQnA(CreateQnARequest request) {
        qnACreator.save(request.toEntity());
    }
}
