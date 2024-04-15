package com.sickgyun.server.recruit.infra.database;

import static com.sickgyun.server.interest.domain.QNotInterested.*;
import static com.sickgyun.server.recruit.domain.QRecruit.*;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sickgyun.server.interest.domain.type.Type;
import com.sickgyun.server.recruit.domain.Recruit;
import com.sickgyun.server.recruit.domain.repository.RecruitQueryRepository;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RecruitQueryRepositoryImpl implements RecruitQueryRepository {

	private final JPAQueryFactory queryFactory;

	@Override
	public List<Recruit> findWithoutNotInterested(User user, Long size) {
		return queryFactory
			.selectFrom(recruit)
			.leftJoin(notInterested)
			.on(
				recruit.id.eq(notInterested.partyId),
				userEq(user),
				notInterested.partyType.eq(Type.RECRUIT)
			)
			.fetchJoin()
			.where(
				notInterested.partyId.isNull().or(
					userNe(user)
				)
			)
			.limit(size)
			.fetch();
	}

	private static BooleanExpression userNe(User user) {
		if (user == null) {
			return Expressions.asBoolean(true).isTrue();
		}
		return notInterested.userId.ne(user.getId());
	}

	private static BooleanExpression userEq(User user) {
		if (user == null) {
			return Expressions.asBoolean(true).isTrue();
		}
		return notInterested.userId.eq(user.getId());
	}
}
