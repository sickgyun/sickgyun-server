package com.sickgyun.server.like.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sickgyun.server.like.domain.Like;
import com.sickgyun.server.qna.QnA;
import com.sickgyun.server.user.domain.User;

public interface LikeRepository extends JpaRepository<Like, Long> {
	boolean existsByQnAAndUser(QnA qnA, User user);
}
