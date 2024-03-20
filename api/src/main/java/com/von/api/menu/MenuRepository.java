package com.von.api.menu;
import java.sql.*;

import com.von.api.enums.Messenger;
import com.von.api.user.User;
import lombok.Getter;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRepository {
    @Getter
    private static final MenuRepository instance;

    static {
        try {
            instance = new MenuRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public Menu returnOneMenu(){
        return null;
    }


    private final Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    private MenuRepository() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/vondb",
                "von",
                "password");
        pstmt = null;
        rs = null;
    }

    public Messenger makeTable() {
        String sql = "CREATE TABLE IF NOT EXISTS menus (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "category VARCHAR(10) NOT NULL," +
                "item VARCHAR(20) NOT NULL)";
        try {
            pstmt = conn.prepareStatement(sql);
            return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL; //executeUpdate : 전송 버튼
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred");
            return Messenger.SQL_ERROR;
        }

    }

    public Messenger removeTable() {
        String sql = "DROP TABLE IF EXISTS menus";
        try {
            pstmt = conn.prepareStatement(sql);
            return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred");
            return Messenger.SQL_ERROR;
        }
    }

    public Messenger insertMenu(Menu menu) {
        String sql = "INSERT INTO menus(category, item) VALUES(?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, menu.getCategory());
            pstmt.setString(2, menu.getItem());
            return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred :" + menu.getCategory() + " " + menu.getItem());
            return Messenger.SQL_ERROR;
        }
    }

    public List<?> getMenusByCategory(String category){
        String sql = "SELECT m.item FROM menus m WHERE category = ?";
        List<Menu> menus = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, category);
            rs = pstmt.executeQuery();
            while(rs.next())    menus.add(Menu.builder()
                    .item(rs.getString(1))
                    .build());
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred");
            return menus;
        }
        return menus;
    }

    public List<Menu> makeFoobar() throws SQLException {
        String sql = "";
        pstmt= conn.prepareStatement(sql);
        rs = pstmt.executeQuery();

        List<Menu> ls = new ArrayList<>();
        if (rs.next()){
            do{
                Menu m = Menu.builder()
                        .item(rs.getString("item"))
                        .category(rs.getString("category"))
                        .build();
                ls.add(m);

            }while (rs.next());

        }else {
            System.out.println("no data");
        }
        return ls;


    }

    public Messenger returnMessenger() throws SQLException {
        String sql = "";
        pstmt = conn.prepareStatement(sql);
        Messenger m  = null;

        return m;

    };


    public List<?> returnAllMenus() throws SQLException {
        List<Menu> ls = new ArrayList<>();
        String sql = "";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        if(rs.next()){
            do {
                Menu menu = Menu.builder()
                        .item(rs.getString("item"))
                        .category(rs.getString("category"))
                        .build();
                ls.add(menu);
            }while (rs.next());

        }else{
            System.out.println("no data");
        }
        return ls;
    }



    public List<String> userMenu() throws SQLException {
        List<String> ls = new ArrayList<>();
        String sql = "";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        if (rs.next()){
            do{
                User user = User.builder()
                        .id(rs.getLong("id"))
                        .username(rs.getString("username"))
                        .password(rs.getString("password"))
                        .name(rs.getString("name"))
                        .addressId(rs.getLong("addressId"))
                        .job(rs.getString("job"))
                        .build();
                ls.add(String.valueOf(user));
            }while (rs.next());
        }else{
            System.out.println("no data");
        }
        return ls;
    }






    public Map<String,?> returnMap() {
        Map<String,?> map = new HashMap<>();
        return map;
    }
}