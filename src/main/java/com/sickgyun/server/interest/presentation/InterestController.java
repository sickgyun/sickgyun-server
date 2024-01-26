package com.sickgyun.server.interest.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sickgyun.server.auth.annotation.LoginRequired;
import com.sickgyun.server.auth.service.implementation.AuthReader;
import com.sickgyun.server.interest.presentation.dto.CreatNotInterestRequest;
import com.sickgyun.server.interest.service.CommandInterestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/interest")
@RequiredArgsConstructor
public class InterestController {
	private final CommandInterestService commandInterestService;
	private final AuthReader authReader;

	@PostMapping("/not")
	@ResponseStatus(HttpStatus.CREATED)
	@LoginRequired
	public void createNotInterested(@Validated @RequestBody CreatNotInterestRequest request) {
		commandInterestService.createNotInterest(authReader.getCurrentUser(), request.partyId(), request.partyType());
	}
}
