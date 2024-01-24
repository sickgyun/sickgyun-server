package com.sickgyun.server.reqruit.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;

public class UrlConnectingError extends SickgyunException {
	public UrlConnectingError() {
		super(HttpStatus.INTERNAL_SERVER_ERROR, "취업 정보 크롤링 도중 서버 연결에 실패하였습니다.");
	}
}
