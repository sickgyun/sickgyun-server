package com.sickgyun.server.article.service;

import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sickgyun.server.article.domain.Article;
import com.sickgyun.server.article.exception.CannotDeleteOthersArticleException;
import com.sickgyun.server.article.service.implementation.ArticleCreator;
import com.sickgyun.server.article.service.implementation.ArticleDeleter;
import com.sickgyun.server.article.service.implementation.ArticleReader;
import com.sickgyun.server.article.service.implementation.ArticleUpdater;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CommandArticleService {
	private final ArticleCreator articleCreator;
	private final ArticleUpdater articleUpdater;
	private final ArticleReader articleReader;
	private final ArticleDeleter articleDeleter;

	public void create(Article entity) {
		articleCreator.create(entity);
	}

	public void update(Article entity, Long updatableId) {
		articleUpdater.update(entity, updatableId);
	}

	public void delete(Long id, User currentUser) {
		Article byId = articleReader.findById(id);
		if (!Objects.equals(byId.getUser().getId(), currentUser.getId())) {
			throw new CannotDeleteOthersArticleException();
		}

		articleDeleter.deleteById(id);
	}
}
