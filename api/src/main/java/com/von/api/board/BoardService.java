package com.von.api.board;

import java.sql.SQLException;
import java.util.Map;

public interface BoardService {
    Map<?,?> readArticles() throws SQLException;

}
