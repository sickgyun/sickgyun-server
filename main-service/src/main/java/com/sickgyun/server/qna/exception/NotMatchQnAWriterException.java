package com.sickgyun.server.qna.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;

public class NotMatchQnAWriterException extends SickgyunException {

	public NotMatchQnAWriterException() {
		super(HttpStatus.FORBIDDEN, "QnA 작성자가 아닙니다.");
	}
}
