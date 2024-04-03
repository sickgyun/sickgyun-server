package com.sickgyun.server.user.presentation.dto;

import com.sickgyun.server.user.domain.User;

public record UserAndAlarmResponse(
	UserResponse user,
	Boolean hasNotification
) {
	public static UserAndAlarmResponse of(User user, Boolean hasNotification) {
		return new UserAndAlarmResponse(UserResponse.from(user), hasNotification);
	}

}
