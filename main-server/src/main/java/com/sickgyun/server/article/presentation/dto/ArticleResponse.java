package com.sickgyun.server.article.presentation.dto;

import java.time.LocalDateTime;

import com.sickgyun.server.article.domain.Article;
import com.sickgyun.server.user.presentation.dto.UserResponse;

public record ArticleResponse(
	Long id,
	String title,
	String imgUrl,
	String url,
	UserResponse user,
	LocalDateTime createdAt
) {
	public ArticleResponse(Article article) {
		this(
			article.getId(),
			article.getTitle(),
			article.getImgUrl(),
			article.getUrl(),
			UserResponse.from(article.getUser()),
			article.getCreatedAt()
		);
	}
}
