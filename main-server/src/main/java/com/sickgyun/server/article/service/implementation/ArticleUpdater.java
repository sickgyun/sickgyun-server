package com.sickgyun.server.article.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.article.domain.Article;
import com.sickgyun.server.article.domain.repository.ArticleRepository;
import com.sickgyun.server.article.exception.ArticleNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleUpdater {
	private final ArticleRepository articleRepository;
	public void update(Article article, Long updatableId) {
		Article updatableArticle = articleRepository.getById(updatableId);

		updatableArticle.update(article);
	}
}
