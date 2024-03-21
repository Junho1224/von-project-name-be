package com.von.api.board;

import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString

public class Board {

    private Long id;

    private String boardName;
    private String boardType;

    @OneToMany

@Builder(builderMethodName = "builder")
    public Board(Long id, String boardName, String boardType) {
        this.id = id;
        this.boardName = boardName;
        this.boardType = boardType;
    }
}
