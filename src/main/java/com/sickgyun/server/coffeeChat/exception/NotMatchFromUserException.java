package com.sickgyun.server.coffeeChat.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;
import com.sickgyun.server.user.domain.User;

public class NotMatchFromUserException extends SickgyunException {

	public NotMatchFromUserException(User user) {
		super(HttpStatus.FORBIDDEN, String.format("%s는 커피챗 제안을 받은 유저가 아닙니다.", user.getName()));
	}
}
