package com.sickgyun.server.commnet.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;

public class NotMatchCommentWriterException extends SickgyunException {
	public NotMatchCommentWriterException() {
		super(HttpStatus.FORBIDDEN, "댓글 작성자가 아닙니다.");
	}
}
