package com.sickgyun.server.interest.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;
import com.sickgyun.server.interest.domain.type.Type;

public class TypeNotExistException extends SickgyunException {
	public TypeNotExistException(Type partyType) {
		super(HttpStatus.BAD_REQUEST, partyType + "타입은 존재하지 않습니다.");
	}
}
