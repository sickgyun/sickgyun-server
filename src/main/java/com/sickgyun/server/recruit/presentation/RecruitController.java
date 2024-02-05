package com.sickgyun.server.recruit.presentation;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sickgyun.server.auth.annotation.LoginOrNot;
import com.sickgyun.server.auth.service.implementation.AuthReader;
import com.sickgyun.server.recruit.presentation.dto.RecruitResponse;
import com.sickgyun.server.recruit.service.QueryRecruitService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recruit")
public class RecruitController {
	private final QueryRecruitService queryRecruitService;
	private final AuthReader authReader;

	@GetMapping
	@LoginOrNot
	public List<RecruitResponse> getRecruits(@RequestParam(defaultValue = "6") Long size) {
		return queryRecruitService.getRecruits(authReader.getNullableCurrentUser(), size)
			.stream()
			.map(RecruitResponse::from)
			.toList();
	}
}
