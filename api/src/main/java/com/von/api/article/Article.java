package com.von.api.article;

import lombok.Builder;

import java.util.Date;

public class Article {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private Date postDate;

    @Builder(builderMethodName = "builder")
    public Article(Long id, String title, String content, String writer, Date postDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.postDate = postDate;
    }
}
