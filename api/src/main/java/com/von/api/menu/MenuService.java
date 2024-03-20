package com.von.api.menu;

import com.von.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface MenuService {

    Messenger makeMenuTable();

    Messenger removeTable();

    List<?> getMenusByCategory(String category);




    Messenger returnMessenger() throws SQLException;

    Menu returnOneMenu();

    List<?> returnAllMenus() throws SQLException;

    Messenger createTable();


    Map<String,?> returnMap() throws SQLException;

    Menu drumgodum();

    List<String> userMenu() throws SQLException;
}

