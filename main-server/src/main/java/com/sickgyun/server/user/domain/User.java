package com.sickgyun.server.user.domain;

import org.hibernate.annotations.DynamicInsert;

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
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private Role role;

	private String name;

	private String email;

	private Long cardinal;

	@Embedded
	private Contact contact;

	@OneToOne(
		fetch = FetchType.EAGER,
		mappedBy = "writer"
	)
	@JoinColumn(name = "PROFILE")
	private Profile profile;

	public User(String name, String email) {
		this.name = name;
		this.email = email;
		this.role = Role.USER;

		long firstTwo = Long.parseLong(email.substring(0, 2));

		if (firstTwo == 20L) {
			this.cardinal = Long.parseLong(email.substring(2, 4)) - 20L;
		} else {
			this.cardinal = firstTwo - 20L;
		}
	}

	public User(String name, String email, Long cardinal) {
		this.name = name;
		this.email = email;
		this.cardinal = cardinal;
	}

	public void updateProfile(Profile profile) {
		this.profile = profile;
	}

	public void updateContact(Contact contact) {
		this.contact = contact;
	}

	public void update(User user) {
		this.email = user.getEmail();
		this.name = user.getName();
	}
}
