package com.sickgyun.server.comment.infra;

import static com.sickgyun.server.comment.domain.QComment.*;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sickgyun.server.comment.domain.Comment;
import com.sickgyun.server.comment.domain.repository.CommentQueryRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentQueryRepositoryImpl implements CommentQueryRepository {

	private final JPAQueryFactory queryFactory;

	@Override
	public List<Comment> findComments(Long qnAId) {
		return queryFactory.selectFrom(comment)
			.leftJoin(comment.parent)
			.fetchJoin()
			.where(comment.qnA.id.eq(qnAId))
			.orderBy(
				comment.parent.id.asc().nullsFirst()
			)
			.fetch();
	}
}
