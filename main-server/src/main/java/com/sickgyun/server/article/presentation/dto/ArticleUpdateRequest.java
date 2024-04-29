package com.sickgyun.server.article.presentation.dto;

import com.sickgyun.server.article.domain.Article;
import com.sickgyun.server.user.domain.User;

public record ArticleUpdateRequest() {
	public Article toEntity(User currentUser) {
		return null;
	}
}
