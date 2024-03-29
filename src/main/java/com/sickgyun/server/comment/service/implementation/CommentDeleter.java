package com.sickgyun.server.comment.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.comment.domain.Comment;
import com.sickgyun.server.comment.domain.repository.CommentRepository;
import com.sickgyun.server.qna.domain.QnA;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentDeleter {

	private final CommentRepository commentRepository;

	public void delete(Comment comment) {
		commentRepository.delete(comment);
	}

	public void deleteByQnA(QnA qnA) {
		commentRepository.deleteByQnA(qnA);
	}
}
