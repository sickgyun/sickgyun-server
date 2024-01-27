package com.sickgyun.server.reqruit.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sickgyun.server.reqruit.domain.Reqruit;
import com.sickgyun.server.reqruit.service.implementation.ReqruitReader;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QueryReqruitService {
	private final ReqruitReader reqruitReader;

	public List<Reqruit> getReqruits(User user, Long size) {
		return reqruitReader.readReqruitsWithoutNoInterest(user, size);
	}
}
