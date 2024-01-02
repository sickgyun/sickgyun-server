package com.sickgyun.server.commnet.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sickgyun.server.commnet.domain.Comment;
import com.sickgyun.server.commnet.service.implementation.CommentCreator;
import com.sickgyun.server.commnet.service.implementation.CommentReader;
import com.sickgyun.server.commnet.service.implementation.CommentUpdater;
import com.sickgyun.server.commnet.service.implementation.CommentValidator;
import com.sickgyun.server.core.qna.QnA;
import com.sickgyun.server.core.qna.service.implementation.QnAReader;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandCommentService {

	private final QnAReader qnAReader;
	private final CommentReader commentReader;
	private final CommentCreator commentCreator;
	private final CommentUpdater commentUpdater;
	private final CommentValidator commentValidator;

	public void createComment(Long qnaId, User writer, Comment comment) {
		QnA qnA = qnAReader.read(qnaId);
		commentCreator.create(comment, qnA, writer);
	}

	public void updateComment(Long commentId, Comment comment, User writer) {
		Comment updatableComment = commentReader.read(commentId);
		commentValidator.validateWriter(updatableComment, writer);
		commentUpdater.update(updatableComment, comment);
	}
}
