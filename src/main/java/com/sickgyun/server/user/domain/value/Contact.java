package com.sickgyun.server.user.domain.value;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
	@ColumnDefault("''")
	private String phoneNumber;
	@ColumnDefault("''")
	private String instagramId;
	@ColumnDefault("''")
	private String kakaoId;
}
