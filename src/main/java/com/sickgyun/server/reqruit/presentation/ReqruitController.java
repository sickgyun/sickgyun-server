package com.sickgyun.server.reqruit.presentation;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sickgyun.server.auth.annotation.LoginOrNot;
import com.sickgyun.server.auth.service.implementation.AuthReader;
import com.sickgyun.server.reqruit.presentation.dto.ReqruitResponse;
import com.sickgyun.server.reqruit.service.QueryReqruitService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reqruit")
public class ReqruitController {
	private final QueryReqruitService queryReqruitService;
	private final AuthReader authReader;

	@GetMapping
	@LoginOrNot
	public List<ReqruitResponse> getReqruits(@RequestParam(defaultValue = "6") Long size) {
		return queryReqruitService.getReqruits(authReader.getNullableCurrentUser(), size)
			.stream()
			.map(ReqruitResponse::new)
			.toList();
	}
}
