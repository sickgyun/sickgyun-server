package com.sickgyun.server.event.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;

public class EventUrlConnectingError extends SickgyunException {
	public EventUrlConnectingError() {
		super(HttpStatus.INTERNAL_SERVER_ERROR, "이벤트 정보 크롤링 도중 서버 연결에 실패하였습니다.");
	}
}
