package com.sickgyun.server.core.service.qna.implementation;

import com.sickgyun.server.core.qna.QnA;
import com.sickgyun.server.core.qna.repository.QnARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QnACreator {

    private final QnARepository qnARepository;

    public void save(QnA qnA) {
        qnARepository.save(qnA);
    }
}
