package com.sickgyun.server.comment.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.comment.domain.Comment;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentUpdater {

	public void update(Comment updatableComment, Comment comment) {
		updatableComment.update(comment);
	}
}
