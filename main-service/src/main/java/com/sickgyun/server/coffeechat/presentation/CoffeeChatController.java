package com.sickgyun.server.coffeechat.presentation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sickgyun.server.auth.annotation.LoginRequired;
import com.sickgyun.server.auth.repository.AuthRepository;
import com.sickgyun.server.coffeechat.presentation.dto.AcceptResponse;
import com.sickgyun.server.coffeechat.presentation.dto.CoffeeChatRequest;
import com.sickgyun.server.coffeechat.presentation.dto.CoffeeChatResponse;
import com.sickgyun.server.coffeechat.presentation.dto.ReceivedCoffeeChatResponse;
import com.sickgyun.server.coffeechat.service.CommandCoffeeChatService;
import com.sickgyun.server.coffeechat.service.QueryCoffeeChatService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/coffeechat")
@RequiredArgsConstructor
public class CoffeeChatController {

	private final CommandCoffeeChatService commandCoffeeChatService;
	private final QueryCoffeeChatService queryCoffeeChatService;
	private final AuthRepository authRepository;

	@PostMapping("/{to-user-id}")
	@ResponseStatus(HttpStatus.CREATED)
	@LoginRequired
	public void create(
		@PathVariable(name = "to-user-id") Long toUserId,
		@RequestBody CoffeeChatRequest request
	) {
		commandCoffeeChatService.create(request.toEntity(authRepository.getCurrentUser()), toUserId);
	}

	@PutMapping("/{chat-id}/accept")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@LoginRequired
	public AcceptResponse accept(
		@PathVariable(name = "chat-id") Long coffeeChatId
	) {
		return AcceptResponse.from(
			commandCoffeeChatService.accept(authRepository.getCurrentUser(), coffeeChatId)
		);
	}

	@PutMapping("/{chat-id}/reject")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@LoginRequired
	public void reject(
		@PathVariable(name = "chat-id") Long coffeeChatId,
		@RequestBody @Validated CoffeeChatRequest request
	) {
		commandCoffeeChatService.reject(authRepository.getCurrentUser(), coffeeChatId, request.message());
	}

	@GetMapping("/my/receive")
	@LoginRequired
	public List<ReceivedCoffeeChatResponse> getReceiveCoffeeChat() {
		return queryCoffeeChatService.getByToUser(authRepository.getCurrentUser()).stream()
			.map(ReceivedCoffeeChatResponse::from)
			.toList();
	}

	@GetMapping("/my/send")
	@LoginRequired
	public List<CoffeeChatResponse> getSendPendingChat() {
		return queryCoffeeChatService.getByFromUser(authRepository.getCurrentUser()).stream()
			.map(CoffeeChatResponse::from)
			.toList();
	}

	@DeleteMapping("/{chat-id}")
	@LoginRequired
	public void deleteCoffeeChat(@PathVariable(name = "chat-id") Long coffeeChatId) {
		commandCoffeeChatService.deleteCoffeeChat(authRepository.getCurrentUser(), coffeeChatId);
	}
}
