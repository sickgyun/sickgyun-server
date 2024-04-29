package com.sickgyun.server.article.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;

public class CannotDeleteOthersArticleException extends SickgyunException {
	public CannotDeleteOthersArticleException() {
		super(HttpStatus.FORBIDDEN, "다른 사람의 글을 삭제할 수 없습니다.");
	}
}
