package com.sickgyun.server.comment.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sickgyun.server.comment.domain.Comment;
import com.sickgyun.server.comment.domain.repository.CommentRepository;
import com.sickgyun.server.qna.QnA;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentReader {

	private final CommentRepository commentRepository;

	public Comment read(Long commentId) {
		return commentRepository.getById(commentId);
	}

	public List<Comment> readByQnA(QnA qnA) {
		return commentRepository.findByQnA(qnA);
	}
}
