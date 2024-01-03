package com.sickgyun.server.commnet.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.commnet.domain.Comment;
import com.sickgyun.server.commnet.domain.repository.CommentRepository;
import com.sickgyun.server.qna.QnA;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentCreator {

	private final CommentRepository commentRepository;

	public void create(Comment comment, QnA qnA, User writer) {
		comment.updateQnA(qnA);
		comment.updateWriter(writer);
		commentRepository.save(comment);
	}
}
