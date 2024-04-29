package com.sickgyun.server.article.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;

public class ArticleNotFoundException extends SickgyunException {
	public ArticleNotFoundException(Long id) {
		super(HttpStatus.NOT_FOUND, "id가 " + id + "인 아티클을 찾을 수 없어요");
	}
}
