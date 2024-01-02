package com.sickgyun.server.commnet.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.commnet.domain.Comment;
import com.sickgyun.server.user.domain.User;

@Service
public class CommentValidator {

	public void validateWriter(Comment comment, User writer) {
		comment.validateWriter(writer);
	}
}
