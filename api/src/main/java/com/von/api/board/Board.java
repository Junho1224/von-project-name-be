package com.von.api.board;

import lombok.Builder;

public class Board {

    private int id;
    private String title;
    private String content;
    private String writer;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }


    @Builder(builderMethodName = "builder")
    public Board(int id, String title, String content, String writer){
        this.id=id;
        this.title=title;
        this.content=content;
        this.writer=writer;

    }


    @Override
    public String toString() {
        return "BoardDTO{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Board(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

}