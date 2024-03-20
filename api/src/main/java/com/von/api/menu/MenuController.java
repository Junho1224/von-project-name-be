package com.von.api.menu;

import com.von.api.enums.Messenger;
import lombok.Getter;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class MenuController {



    @Getter
    private static final MenuController instance = new MenuController();

    private final MenuService menuService;
    private MenuController(){
        menuService = MenuServiceImpl.getInstance();
    }

    public Messenger makeMenuTable(){
        return menuService.makeMenuTable();
    }
    public Messenger removeMenuTable(){
        return menuService.removeTable();
    }

    public List<?> getMenusByCategory(String category){
        return menuService.getMenusByCategory(category);
    }

    public Messenger createTable() {
        return menuService.createTable();

    }

    public Messenger returnMessenger() throws SQLException {
        Messenger m = menuService.returnMessenger();
        return m;
    }

    public Menu returnOneMenu() {
        return menuService.returnOneMenu();
    }

    public List<?> returnAllMenus() throws SQLException {
        return menuService.returnAllMenus();

    }

    public Map<String,?> returnMap() throws SQLException {
        return menuService.returnMap();
    }

    public Menu drumgodum() {
        return menuService.drumgodum();
    }

    public List<String> userMenu() throws SQLException {
        return menuService.userMenu();
    }
}


