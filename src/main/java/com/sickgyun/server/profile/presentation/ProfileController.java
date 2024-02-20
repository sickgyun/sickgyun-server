package com.sickgyun.server.profile.presentation;

import java.util.List;

import org.springframework.http.HttpStatus;
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
import com.sickgyun.server.profile.presentation.dto.FilterRequest;
import com.sickgyun.server.profile.presentation.dto.ProfileCreateRequest;
import com.sickgyun.server.profile.presentation.dto.ProfileResponse;
import com.sickgyun.server.profile.presentation.dto.ProfileUpdateRequest;
import com.sickgyun.server.profile.presentation.dto.SimpleProfileResponse;
import com.sickgyun.server.profile.service.CommandProfileService;
import com.sickgyun.server.profile.service.QueryProfileService;
import com.sickgyun.server.user.domain.User;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profiles")
public class ProfileController {
	private final CommandProfileService commandService;
	private final QueryProfileService queryService;
	private final AuthRepository authRepository;

	@PostMapping
	@LoginRequired
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@Valid @RequestBody ProfileCreateRequest requestDto) {

		commandService.create(requestDto.toEntity(), authRepository.getCurrentUser());
	}

	@PutMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@Valid @RequestBody ProfileUpdateRequest requestDto) {
		commandService.update(requestDto.toEntity(), authRepository.getCurrentUser());
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<SimpleProfileResponse> readAll(FilterRequest filterRequest) {
		return queryService.readAll(filterRequest.toDomain())
			.stream()
			.map(SimpleProfileResponse::from)
			.toList();
	}

	@GetMapping("/{profile-id}")
	@ResponseStatus(HttpStatus.OK)
	public ProfileResponse readOne(@PathVariable(name = "profile-id") Long profileId) {
		return ProfileResponse.from(queryService.readOne(profileId));
	}

	@GetMapping("/mine")
	@LoginRequired
	@ResponseStatus(HttpStatus.OK)
	public ProfileResponse readMine() {
		User currentUser = authRepository.getCurrentUser();
		return ProfileResponse.from(queryService.readMine(currentUser));
	}
}
