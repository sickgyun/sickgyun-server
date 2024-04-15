package com.sickgyun.server.coffeechat.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;

public class HasSameCoffeeChatPendingException extends SickgyunException {
	public HasSameCoffeeChatPendingException(String toUserName) {
		super(HttpStatus.BAD_REQUEST, toUserName + "님에게 보낸, 결정되지 않는 커피챗이 존재합니다.");
	}
}
