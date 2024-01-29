package com.sickgyun.server.recruit.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sickgyun.server.recruit.domain.Recruit;
import com.sickgyun.server.recruit.service.implementation.RecruitReader;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QueryRecruitService {
	private final RecruitReader recruitReader;

	public List<Recruit> getReqruits(User user, Long size) {
		return recruitReader.readReqruitsWithoutNoInterest(user, size);
	}
}
