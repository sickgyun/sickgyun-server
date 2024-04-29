package com.sickgyun.server.article.service.implementation;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sickgyun.server.article.domain.Article;
import com.sickgyun.server.article.domain.repository.ArticleRepository;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleReader {
	private final ArticleRepository articleRepository;

	public List<Article> findAll() {
		return articleRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
	}

	public Article findById(Long id) {
		return articleRepository.getById(id);
	}

	public List<Article> findMine(User user) {
		return articleRepository.findByUser(user);
	}
}
