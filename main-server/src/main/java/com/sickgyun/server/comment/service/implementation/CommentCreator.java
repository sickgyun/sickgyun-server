package com.sickgyun.server.comment.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.comment.domain.Comment;
import com.sickgyun.server.comment.domain.repository.CommentRepository;
import com.sickgyun.server.qna.domain.QnA;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentCreator {

	private final CommentRepository commentRepository;

	public void create(Comment comment, QnA qnA, User writer, Comment parent) {
		comment.updateQnA(qnA);
		comment.updateWriter(writer);
		comment.updateParent(parent);
		commentRepository.save(comment);
	}
}
