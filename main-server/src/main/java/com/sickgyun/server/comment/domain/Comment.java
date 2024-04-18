package com.sickgyun.server.comment.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.sickgyun.server.qna.domain.QnA;
import com.sickgyun.server.user.domain.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comment_id")
	private Long id;

	private String content;

	private LocalDateTime createTime;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User writer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "qna_id")
	private QnA qnA;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Comment parent;

	@OneToMany(mappedBy = "parent", orphanRemoval = true)
	private List<Comment> children = new ArrayList<>();

	public Comment(String content) {
		this.content = content;
		this.createTime = LocalDateTime.now();
	}

	public void updateQnA(QnA qnA) {
		this.qnA = qnA;
	}

	public void updateWriter(User writer) {
		this.writer = writer;
	}

	public void updateParent(Comment parent) {
		this.parent = parent;
	}

	public void update(Comment comment) {
		this.content = comment.getContent();
	}
}
