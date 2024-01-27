package com.sickgyun.server.reqruit.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.reqruit.domain.repository.ReqruitRepository;
import com.sickgyun.server.reqruit.exception.ReqruitIsNotExistException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReqruitValidator {
	private final ReqruitRepository reqruitRepository;

	public void requiredShouldBeExist(Long requireId) {
		boolean isExist = reqruitRepository.existsById(requireId);

		if (!isExist) {
			throw new ReqruitIsNotExistException(requireId);
		}
	}
}
