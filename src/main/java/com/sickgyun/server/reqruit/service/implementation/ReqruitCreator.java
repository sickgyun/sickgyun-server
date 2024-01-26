package com.sickgyun.server.reqruit.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sickgyun.server.reqruit.domain.Reqruit;
import com.sickgyun.server.reqruit.domain.repository.ReqruitRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReqruitCreator {
	private final ReqruitRepository reqruitRepository;

	public void createAll(List<Reqruit> reqruits) {
		reqruitRepository.saveAll(reqruits);
	}
}
