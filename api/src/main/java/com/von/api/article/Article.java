package com.von.api.article;

import com.von.api.board.Board;
import com.von.api.user.User;

import lombok.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
@Entity(name = "articles")
public class Article {

    @Id
    @Column(name ="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;

    @Column(name = "register_date")
    private String registerDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer", nullable = true)
    private User writer;

    @ManyToOne
    @JoinColumn(name = "board", nullable = true)
    private Board board;

    @Builder(builderMethodName = "builder")
    public Article(Long id, String title, String content, User writer, String registerDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.registerDate = registerDate;
    }


}
