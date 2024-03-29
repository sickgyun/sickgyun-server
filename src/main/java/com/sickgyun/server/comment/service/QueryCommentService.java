package com.sickgyun.server.comment.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sickgyun.server.comment.domain.Comment;
import com.sickgyun.server.comment.service.implementation.CommentReader;
import com.sickgyun.server.qna.domain.QnA;
import com.sickgyun.server.qna.service.implementation.QnAReader;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryCommentService {

	private final CommentReader commentReader;
	private final QnAReader qnAReader;

	public List<Comment> findByQnA(Long qnAId) {
		QnA qnA = qnAReader.read(qnAId);
		return commentReader.readByQnA(qnA);
	}
}
