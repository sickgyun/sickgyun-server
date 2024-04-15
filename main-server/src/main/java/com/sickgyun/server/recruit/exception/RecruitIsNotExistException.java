package com.sickgyun.server.recruit.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;

public class RecruitIsNotExistException extends SickgyunException {
	public RecruitIsNotExistException(Long requireId) {
		super(HttpStatus.NOT_FOUND, requireId + "이 아이디인 채용공고가 존재하지 않습니다.");
	}
}
