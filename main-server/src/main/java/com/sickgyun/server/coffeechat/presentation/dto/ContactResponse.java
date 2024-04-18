package com.sickgyun.server.coffeechat.presentation.dto;

import com.sickgyun.server.user.domain.value.Contact;

public record ContactResponse(
	String phoneNumber,
	String instagramId,
	String kakaoId
) {
	public static ContactResponse from(Contact contact) {
		return new ContactResponse(contact.getPhoneNumber(), contact.getInstagramId(), contact.getKakaoId());
	}
}
