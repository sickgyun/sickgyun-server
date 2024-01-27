package com.sickgyun.server.reqruit.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sickgyun.server.reqruit.domain.Reqruit;
import com.sickgyun.server.reqruit.domain.repository.ReqruitQueryRepository;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReqruitReader {
	private final ReqruitQueryRepository reqruitQueryRepository;

	public List<Reqruit> readReqruitsWithoutNoInterest(User user, Long size) {
		return reqruitQueryRepository.findWithoutNotInterested(user, size);
	}
}
