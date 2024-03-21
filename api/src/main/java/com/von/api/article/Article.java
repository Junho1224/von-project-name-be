package com.von.api.article;

import com.von.api.board.Board;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString(exclude = {"id"})
@Entity(name = "article")
public class Article {

    @GeneratedValue(strategy = GenerationType.AUTO)

    @Id
    @Column(name = "id")
    private Long id; // primary key
    
    @ManyToOne
    @JoinColumn(name = "id")
    private Board Board_id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "WRITER")
    private String writer;

    @Column(name = "REGISTERDATE")
    private String registerDate;

    @Builder(builderMethodName = "builder")
    public Article(Long id, String title, String content, String writer, String registerDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.registerDate = registerDate;
    }
}
