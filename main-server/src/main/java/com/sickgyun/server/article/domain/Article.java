package com.sickgyun.server.article.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import com.sickgyun.server.user.domain.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String imgUrl;
	private String url;
	@OneToOne(fetch = FetchType.LAZY)
	private User user;
	@CreatedDate
	private LocalDateTime createdAt;

	public Article(String title, String imgUrl, String url, User user) {
		this.title = title;
		this.imgUrl = imgUrl;
		this.url = url;
		this.user = user;
	}

	public void update(Article article) {
		this.title = article.getTitle();
		this.imgUrl = article.getImgUrl();
		this.url = article.getUrl();
		this.user = article.getUser();
	}
}
