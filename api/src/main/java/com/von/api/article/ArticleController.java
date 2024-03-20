package com.von.api.article;

import com.von.api.account.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticleController {
    private final AccountServiceImpl service;

    public List<Article> findAll() throws SQLException {
        return null;
    }
}
