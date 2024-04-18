package com.sickgyun.server.interest.domain;

import com.sickgyun.server.interest.domain.type.Type;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NotInterested {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	Long userId;
	Long partyId;
	@Enumerated(EnumType.STRING)
	Type partyType;

	public NotInterested(Long userId, Long partyId, Type partyType) {
		this.userId = userId;
		this.partyId = partyId;
		this.partyType = partyType;
	}
}
