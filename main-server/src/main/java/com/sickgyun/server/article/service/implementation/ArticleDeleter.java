package com.sickgyun.server.article.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.article.domain.repository.ArticleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleDeleter {
	private final ArticleRepository articleRepository;

	public void deleteById(Long id) {
		articleRepository.deleteById(id);
	}
}
