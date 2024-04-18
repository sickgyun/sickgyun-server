package com.sickgyun.server.comment.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.comment.exception.NotMatchCommentWriterException;
import com.sickgyun.server.user.domain.User;

@Service
public class CommentValidator {

	public void shouldBeSameUser(User commentWriter, User writer) {
		if (!commentWriter.getId().equals(writer.getId())) {
			throw new NotMatchCommentWriterException();
		}
	}
}
