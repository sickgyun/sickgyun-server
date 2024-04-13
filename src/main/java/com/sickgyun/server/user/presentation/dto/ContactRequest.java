package com.sickgyun.server.user.presentation.dto;

import com.sickgyun.server.user.domain.value.Contact;

public record ContactRequest(
	String phone,
	String instagram,
	String kakao
) {
	public Contact toEntity() {
		return new Contact(phone, instagram, kakao);
	}
}
