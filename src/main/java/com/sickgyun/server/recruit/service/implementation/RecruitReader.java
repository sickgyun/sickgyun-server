package com.sickgyun.server.recruit.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sickgyun.server.recruit.domain.Recruit;
import com.sickgyun.server.recruit.domain.repository.RecruitQueryRepository;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecruitReader {
	private final RecruitQueryRepository recruitQueryRepository;

	public List<Recruit> readRecruitsWithoutNoInterest(User user, Long size) {
		return recruitQueryRepository.findWithoutNotInterested(user, size);
	}
}
