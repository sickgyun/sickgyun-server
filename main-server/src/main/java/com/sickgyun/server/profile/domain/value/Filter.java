package com.sickgyun.server.profile.domain.value;

public record Filter(
	Boolean isRecruited,
	Major major,
	Long cardinal
) {
}
