package com.sickgyun.server.like.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sickgyun.server.like.domain.Like;
import com.sickgyun.server.like.exception.LikeNotFoundException;
import com.sickgyun.server.qna.QnA;
import com.sickgyun.server.user.domain.User;

public interface LikeRepository extends JpaRepository<Like, Long> {
	boolean existsByQnAAndUser(QnA qnA, User user);

	Optional<Like> findByQnAAndUser(QnA qnA, User user);

	default Like getLike(QnA qnA, User user) {
		return findByQnAAndUser(qnA, user)
			.orElseThrow(LikeNotFoundException::new);
	}
}
