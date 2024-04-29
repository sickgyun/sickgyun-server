package com.sickgyun.server.article.presentation.dto;

import com.sickgyun.server.article.domain.Article;
import com.sickgyun.server.user.domain.User;

import jakarta.validation.constraints.NotNull;

public record ArticleCreateRequest(
	@NotNull(message = "title은 필수 값입니다.")
	String title,
	@NotNull(message = "imgUrl은 필수 값입니다.")
	String imgUrl,
	@NotNull(message = "url은 필수 값입니다.")
	String url

) {
	public Article toEntity(User currentUser) {
		return new Article(
			title,
			imgUrl,
			url,
			currentUser
		);
	}
}
