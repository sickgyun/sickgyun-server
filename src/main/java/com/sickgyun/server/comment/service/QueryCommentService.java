package com.sickgyun.server.comment.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sickgyun.server.comment.domain.Comment;
import com.sickgyun.server.comment.service.implementation.CommentReader;
import com.sickgyun.server.qna.domain.QnA;
import com.sickgyun.server.qna.service.implementation.QnAReader;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryCommentService {

	private final CommentReader commentReader;
	private final QnAReader qnAReader;

	public List<Comment> findByQnA(Long qnAId) {
		QnA qnA = qnAReader.read(qnAId);
		return convertStructure(commentReader.readByQnA(qnA));
	}

	private List<Comment> convertStructure(List<Comment> comments) {
		List<Comment> result = new ArrayList<>();
		Map<Long, Comment> map = new HashMap<>();
		comments.forEach(
			comment -> {
				map.put(comment.getId(), comment);
				if (comment.getParent() != null) {
					map.get(comment.getParent().getId()).getChildren().add(comment);
				} else {
					result.add(comment);
				}
			}
		);

		return result;
	}
}
