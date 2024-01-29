package com.sickgyun.server.reqruit.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.recruit.domain.repository.RecruitRepository;
import com.sickgyun.server.recruit.exception.RecruitIsNotExistException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReqruitValidator {
	private final RecruitRepository recruitRepository;

	public void requiredShouldBeExist(Long requireId) {
		boolean isExist = recruitRepository.existsById(requireId);

		if (!isExist) {
			throw new RecruitIsNotExistException(requireId);
		}
	}
}
