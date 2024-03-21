package com.von.api.board;

import java.util.List;

import com.von.api.article.Article;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"id"})
@Entity(name = "board")
public class Board {

    @GeneratedValue(strategy = GenerationType.AUTO)

    @Id
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "Board")
    private List<Article> articles;

    @Column(name = "BOARDNAME")
    private String boardName;
    @Column(name = "BOARDTYPE")
    private String boardType;
    


    @Builder(builderMethodName = "builder")
    public Board(Long id, String boardName, String boardType) {
        //this.id = id;
        this.boardName = boardName;
        this.boardType = boardType;
    }

}