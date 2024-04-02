package com.sickgyun.server.qna.domain;

import java.time.LocalDateTime;

import com.sickgyun.server.qna.domain.value.Category;
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
public class QnA {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "qna_id")
	private Long id;

	@Column(nullable = false, length = 40)
	private String title;

	@Column(nullable = false, length = 400)
	private String content;

	private LocalDateTime createTime;

	@Enumerated(EnumType.STRING)
	private Category category;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User writer;

	public QnA(String title, String content, Category category) {
		this.title = title;
		this.content = content;
		this.category = category;
		this.createTime = LocalDateTime.now();
	}

	public void update(QnA qnA) {
		this.title = qnA.getTitle();
		this.content = qnA.getContent();
		this.category = qnA.getCategory();
	}

	public void updateWriter(User user) {
		this.writer = user;
	}
}
