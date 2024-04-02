package com.sickgyun.server.qna.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.qna.exception.NotMatchQnAWriterException;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QnAValidator {

	public void shouldBeSameUser(User writer, User user) {
		if (!writer.getId().equals(user.getId())) {
			throw new NotMatchQnAWriterException();
		}
	}
}
