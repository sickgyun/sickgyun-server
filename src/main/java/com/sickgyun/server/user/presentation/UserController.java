package com.sickgyun.server.user.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sickgyun.server.auth.annotation.LoginRequired;
import com.sickgyun.server.auth.service.implementation.AuthReader;
import com.sickgyun.server.user.presentation.dto.UserRequest;
import com.sickgyun.server.user.service.CommandUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

	private final CommandUserService commandUserService;
	private final AuthReader authReader;

	@PutMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@LoginRequired
	public void updateContact(@RequestBody UserRequest request) {
		commandUserService.updateContact(authReader.getCurrentUser(), request.contact());
	}
}
