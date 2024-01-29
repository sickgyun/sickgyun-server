package com.sickgyun.server.recruit.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sickgyun.server.recruit.domain.Recruit;
import com.sickgyun.server.recruit.domain.repository.RecruitRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecruitCreator {
	private final RecruitRepository recruitRepository;

	public void createAll(List<Recruit> recruits) {
		recruitRepository.saveAll(recruits);
	}
}
