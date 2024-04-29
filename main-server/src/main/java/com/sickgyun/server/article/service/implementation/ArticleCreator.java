package com.sickgyun.server.article.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.article.domain.Article;
import com.sickgyun.server.article.domain.repository.ArticleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleCreator {
	private final ArticleRepository articleRepository;

	public void create(Article entity) {
		articleRepository.save(entity);
	}
}
