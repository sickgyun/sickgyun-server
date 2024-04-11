package com.sickgyun.server.comment.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sickgyun.server.comment.domain.Comment;
import com.sickgyun.server.comment.domain.repository.CommentQueryRepository;
import com.sickgyun.server.comment.domain.repository.CommentRepository;
import com.sickgyun.server.qna.domain.QnA;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentReader {

	private final CommentRepository commentRepository;
	private final CommentQueryRepository commentQueryRepository;

	public Comment read(Long commentId) {
		return commentRepository.getById(commentId);
	}

	public List<Comment> readByQnA(QnA qnA) {
		return commentQueryRepository.findComments(qnA.getId());
	}
}
