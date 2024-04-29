package com.sickgyun.server.article.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sickgyun.server.article.domain.Article;
import com.sickgyun.server.article.service.implementation.ArticleReader;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QueryArticleService {
	private final ArticleReader articleReader;

	public List<Article> getAll() {
		return articleReader.findAll();
	}

	public Article getOne(Long id) {
		return articleReader.findById(id);
	}

	public List<Article> findMine(User user) {
		return articleReader.findMine(user);
	}
}
