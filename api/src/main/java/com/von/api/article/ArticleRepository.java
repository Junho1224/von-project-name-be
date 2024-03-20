package com.von.api.article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {

    Connection connection;

    private final static ArticleRepository instance;

    static {
        try {
            instance = new ArticleRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ArticleRepository() throws SQLException {
        this.connection = null;
    }

    public static ArticleRepository getInstance() {
        return instance;
    }

    public List<Article> findAll() throws SQLException {
        List<Article> ls = new ArrayList<>();
        String sql = "select * from articles";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            do {
                ls.add(Article.builder()
                        .id(rs.getLong("id"))
                        .title(rs.getString("title"))
                        .content(rs.getString("content"))
                        .writer(rs.getString("writer"))
                        .postDate(rs.getDate("writeDate"))
                        .build());
            }
            while (rs.next());
        } else {
            System.out.println("No Data");
        }
        rs.close();
        pstmt.close();
        connection.close();

        return ls;
    }
}
