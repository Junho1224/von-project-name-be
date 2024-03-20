package com.von.api.board;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private static BoardService service;

    public Map<?,?> readArticles() throws SQLException {
        Map<String, String> map = new HashMap<>();
        return map;
    }
}
