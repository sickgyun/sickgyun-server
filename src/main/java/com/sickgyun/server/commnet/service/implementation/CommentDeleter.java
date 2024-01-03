package com.sickgyun.server.commnet.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.commnet.domain.Comment;
import com.sickgyun.server.commnet.domain.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentDeleter {

	private final CommentRepository commentRepository;

	public void delete(Comment comment) {
		commentRepository.delete(comment);
	}
}
