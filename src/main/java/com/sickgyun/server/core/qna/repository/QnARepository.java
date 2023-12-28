package com.sickgyun.server.core.qna.repository;

import com.sickgyun.server.core.qna.QnA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QnARepository extends JpaRepository<QnA, Long> {

    List<QnA> findAllByOrderByIdDesc();
}
