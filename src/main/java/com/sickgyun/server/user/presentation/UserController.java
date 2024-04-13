package com.sickgyun.server.user.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sickgyun.server.auth.annotation.LoginRequired;
import com.sickgyun.server.auth.service.implementation.AuthReader;
import com.sickgyun.server.coffeechat.service.QueryCoffeeChatService;
import com.sickgyun.server.user.presentation.dto.ContactRequest;
import com.sickgyun.server.user.presentation.dto.UserAndAlarmResponse;
import com.sickgyun.server.user.presentation.dto.UserResponse;
import com.sickgyun.server.user.service.CommandUserService;
import com.sickgyun.server.user.service.QueryUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

	private final CommandUserService commandUserService;
	private final QueryUserService queryUserService;
	private final QueryCoffeeChatService queryCoffeeChatService;
	private final AuthReader authReader;

	@PutMapping("/contact")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@LoginRequired
	public void updateContact(@RequestBody @Validated ContactRequest request) {
		commandUserService.updateContact(authReader.getCurrentUser(), request.toEntity());
	}

	@GetMapping("/{user-id}")
	public UserResponse readById(@PathVariable(name = "user-id") Long id) {
		return UserResponse.from(queryUserService.readById(id));
	}

	@GetMapping
	@LoginRequired
	public UserAndAlarmResponse readByCurrent() {
		return UserAndAlarmResponse.of(
			authReader.getCurrentUser(),
			queryCoffeeChatService.hasPendingCoffeeChatRequest(authReader.getCurrentUser())
		);
	}
}
