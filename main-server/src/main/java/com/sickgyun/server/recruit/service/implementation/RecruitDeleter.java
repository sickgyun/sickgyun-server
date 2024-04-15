package com.sickgyun.server.recruit.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.recruit.domain.repository.RecruitRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecruitDeleter {
	private final RecruitRepository recruitRepository;

	public void deleteAll() {
		recruitRepository.deleteAll();
	}
}
