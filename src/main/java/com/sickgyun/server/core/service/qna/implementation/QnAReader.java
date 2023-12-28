package com.sickgyun.server.core.service.qna.implementation;

import com.sickgyun.server.core.qna.QnA;
import com.sickgyun.server.core.qna.repository.QnARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QnAReader {

    private final QnARepository qnARepository;

    public List<QnA> readAll() {
        return qnARepository.findAllByOrderByIdDesc();
    }
}
