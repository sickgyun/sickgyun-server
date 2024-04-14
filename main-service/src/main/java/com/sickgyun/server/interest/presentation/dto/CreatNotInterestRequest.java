package com.sickgyun.server.interest.presentation.dto;

import com.sickgyun.server.interest.domain.type.Type;

import jakarta.validation.constraints.NotNull;

public record CreatNotInterestRequest(
	@NotNull(message = "partyId는 null일 수 없습니다.")
	Long partyId,

	@NotNull(message = "partyType은 null일 수 없습니다.")
	Type partyType
) {
}
