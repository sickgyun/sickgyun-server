package com.sickgyun.server.user.domain;

import com.sickgyun.server.profile.domain.Profile;
import com.sickgyun.server.user.domain.role.Role;
import com.sickgyun.server.user.domain.value.Contact;

import jakarta.persistence.Embedded;
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

	@Embedded
	private Contact contact;

	@OneToOne(
		fetch = FetchType.LAZY,
		mappedBy = "writer"
	)
	@JoinColumn(name = "PROFILE")
	Profile profile;

	public void updateProfile(Profile profile) {
		this.profile = profile;
	}

	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public void update(User user) {
		this.email = user.getEmail();
		this.name = user.getName();
	}

	public void updateContact(Contact contact) {
		this.contact = contact;
	}
}
