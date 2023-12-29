package com.sickgyun.server.core.qna;

import com.sickgyun.server.core.qna.value.Category;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
}
