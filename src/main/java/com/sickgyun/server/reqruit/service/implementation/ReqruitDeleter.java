package com.sickgyun.server.reqruit.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.reqruit.domain.repository.ReqruitRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReqruitDeleter {
	private final ReqruitRepository reqruitRepository;

	public void deleteAll() {
		reqruitRepository.deleteAll();
	}
}
