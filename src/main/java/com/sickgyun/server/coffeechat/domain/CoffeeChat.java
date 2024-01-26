package com.sickgyun.server.coffeechat.domain;

import com.sickgyun.server.coffeechat.domain.value.State;
import com.sickgyun.server.user.domain.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CoffeeChat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "coffeeChat_id")
	private Long id;

	private String message;

	@Enumerated(EnumType.STRING)
	private State state;

	@ManyToOne
	@JoinColumn(name = "to_user_id")
	private User toUser;

	@ManyToOne
	@JoinColumn(name = "from_user_id")
	private User fromUser;

	public CoffeeChat(String message, State state, User fromUser) {
		this.message = message;
		this.state = state;
		this.fromUser = fromUser;
	}

	public void updateToUser(User toUser) {
		this.toUser = toUser;
	}

	public void updateState(State state) {
		this.state = state;
	}
}
