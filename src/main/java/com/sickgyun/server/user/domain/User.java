package com.sickgyun.server.user.domain;

import java.time.LocalDateTime;

import com.sickgyun.server.profile.domain.Profile;
import com.sickgyun.server.user.domain.role.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private Role role;

	private String name;

	private String email;

	private Boolean isGraduated;

	private Long cardinal;

	private Boolean hasCreatedProfile;

	@OneToOne(
		fetch = FetchType.LAZY,
		mappedBy = "writer"
	)
	@JoinColumn(name = "PROFILE")
	private Profile profile;

	public void updateProfile(Profile profile) {
		this.profile = profile;
	}

	public User(String name, String email) {
		this.name = name;
		this.email = email;
		this.role = Role.USER;
		this.hasCreatedProfile = false;

		long firstTwo = Long.parseLong(email.substring(0, 2));

		if (firstTwo == 20L) {
			this.cardinal = Long.parseLong(email.substring(2, 4)) - 20L;
		} else {
			this.cardinal = firstTwo - 20L;
		}

		this.isGraduated = LocalDateTime.now().getYear() - this.cardinal >= 2023;
	}

	public User(String name, String email, Boolean isGraduated, Long cardinal) {
		this.name = name;
		this.email = email;
		this.isGraduated = isGraduated;
		this.cardinal = cardinal;
	}

	public void update(User user) {
		this.email = user.getEmail();
		this.name = user.getName();
		this.isGraduated = user.getIsGraduated();
	}

	public void updateUser(User user) {
		this.email = user.getEmail();
		this.name = user.getName();
		this.isGraduated = user.getIsGraduated();
		this.cardinal = user.getCardinal();
	}

	public void hasCreatedProfile() {
		this.hasCreatedProfile = true;
	}
}
