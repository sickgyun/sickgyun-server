package com.sickgyun.server.comment.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sickgyun.server.comment.domain.Comment;
import com.sickgyun.server.comment.service.implementation.CommentCreator;
import com.sickgyun.server.comment.service.implementation.CommentDeleter;
import com.sickgyun.server.comment.service.implementation.CommentReader;
import com.sickgyun.server.comment.service.implementation.CommentUpdater;
import com.sickgyun.server.comment.service.implementation.CommentValidator;
import com.sickgyun.server.qna.domain.QnA;
import com.sickgyun.server.qna.service.implementation.QnAReader;
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
	private final CommentDeleter commentDeleter;
	private final CommentValidator commentValidator;

	public void createComment(Long qnaId, User writer, Comment comment) {
		QnA qnA = qnAReader.read(qnaId);
		commentCreator.create(comment, qnA, writer);
	}

	public void updateComment(Long commentId, Comment comment, User writer) {
		Comment updatableComment = commentReader.read(commentId);
		commentValidator.shouldBeSameUser(updatableComment.getWriter(), writer);
		commentUpdater.update(updatableComment, comment);
	}

	public void deleteComment(Long commentId, User writer) {
		Comment comment = commentReader.read(commentId);
		commentValidator.shouldBeSameUser(comment.getWriter(), writer);
		commentDeleter.delete(comment);
	}
}
