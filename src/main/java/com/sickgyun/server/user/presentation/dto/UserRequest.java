package com.sickgyun.server.user.presentation.dto;

import com.sickgyun.server.user.domain.value.Contact;

public record UserRequest(
	Contact contact
) {
}
