package com.sickgyun.server.core.service.qna;

import com.sickgyun.server.core.presentation.qna.dto.QnAResponse;
import com.sickgyun.server.core.service.qna.implementation.QnAReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryQnAService {

    private final QnAReader qnAReader;

    public List<QnAResponse> findAll() {
        return qnAReader.readAll().stream()
                .map(QnAResponse::from)
                .toList();
    }
}