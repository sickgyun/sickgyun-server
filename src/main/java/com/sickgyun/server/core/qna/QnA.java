package com.sickgyun.server.core.qna;

import java.time.LocalDateTime;

import com.sickgyun.server.core.presentation.qna.dto.CreateQnARequest;
import com.sickgyun.server.core.qna.value.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

	public QnA(String title, String content, Category category) {
		this.title = title;
		this.content = content;
		this.category = category;
		this.createTime = LocalDateTime.now();
	}

	public void update(CreateQnARequest request) {
		this.title = request.title();
		this.content = request.content();
		this.category = request.category();
	}
}
