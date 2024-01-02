package com.sickgyun.server.profile.presentation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sickgyun.server.profile.presentation.dto.FilterRequest;
import com.sickgyun.server.profile.presentation.dto.ProfileCreateRequest;
import com.sickgyun.server.profile.presentation.dto.ProfileUpdateRequest;
import com.sickgyun.server.profile.presentation.dto.SimpleProfileResponse;
import com.sickgyun.server.profile.service.CommandProfileService;
import com.sickgyun.server.profile.service.QueryProfileService;
import com.sickgyun.server.user.domain.User;
import com.sickgyun.server.user.service.UserTempService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("profiles")
public class ProfileController {
	private final CommandProfileService commandService;
	private final QueryProfileService queryService;
	private final UserTempService userTempService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@Valid @RequestBody ProfileCreateRequest requestDto) {
		//TODO getCurrent User
		User writer = userTempService.getUserId1();

		commandService.create(requestDto.toEntity(), writer);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void update(@Valid @RequestBody ProfileUpdateRequest requestDto) {
		//TODO getCurrent User
		User writer = userTempService.getUserId1();

		commandService.update(requestDto.toEntity(), writer);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<SimpleProfileResponse> readAll(@Valid FilterRequest filterRequest) {
		return queryService.readAll(filterRequest.toDomain())
			.stream()
			.map(SimpleProfileResponse::from)
			.toList();
	}
}
