package com.von.api.menu;

import com.von.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

public interface MenuService {
    Messenger makeMenuTable();

    Messenger removeTable();

    List<?> getMenusByCategory(String category);

//    Messenger returnMessenger();

    List<?> returnAllMenus(String category) throws SQLException;

}
