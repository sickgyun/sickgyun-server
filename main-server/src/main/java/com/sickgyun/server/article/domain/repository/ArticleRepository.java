package com.sickgyun.server.article.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sickgyun.server.article.domain.Article;
import com.sickgyun.server.article.exception.ArticleNotFoundException;
import com.sickgyun.server.user.domain.User;

public interface ArticleRepository extends JpaRepository<Article, Long> {

	default Article getById(Long id) {
		return findById(id)
			.orElseThrow(() -> new ArticleNotFoundException(id));
	}

	List<Article> findByUser(User user);
}
