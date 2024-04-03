package com.sickgyun.server.comment.domain.repository;

import java.util.List;

import com.sickgyun.server.comment.domain.Comment;

public interface CommentQueryRepository {

	List<Comment> findComments(Long qnAId);
}
