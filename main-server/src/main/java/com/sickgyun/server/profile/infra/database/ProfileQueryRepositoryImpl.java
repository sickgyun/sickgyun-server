package com.sickgyun.server.profile.infra.database;

import static com.sickgyun.server.profile.domain.QProfile.*;
import static com.sickgyun.server.user.domain.QUser.*;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sickgyun.server.profile.domain.Profile;
import com.sickgyun.server.profile.domain.repository.ProfileQueryRepository;
import com.sickgyun.server.profile.domain.value.Filter;
import com.sickgyun.server.profile.domain.value.Major;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProfileQueryRepositoryImpl implements ProfileQueryRepository {

	private final JPAQueryFactory queryFactory;

	@Override
	public List<Profile> findAllFiltered(Filter filter) {
		return queryFactory
			.selectFrom(profile)
			.leftJoin(profile.writer, user)
			.fetchJoin()
			.where(
				majorFilter(filter.major()),
				recruitedFilter(filter.isRecruited()),
				cardinalFilter(filter.cardinal())
			).fetch();
	}

	private BooleanExpression majorFilter(Major major) {
		if (major == null) {
			return null;
		}

		return profile.information.major.eq(major);
	}

	private BooleanExpression recruitedFilter(Boolean isRecruited) {
		if (isRecruited == null) {
			return null;
		}

		return profile.company.isNotEmpty();
	}

	private BooleanExpression cardinalFilter(Long cardinal) {
		if (cardinal == null) {
			return null;
		}

		return user.cardinal.eq(cardinal);
	}
}
