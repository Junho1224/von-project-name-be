package com.von.api.menu;

import com.von.api.enums.Messenger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MenuController {
    private final MenuService service;

    public Messenger makeMenuTable(){
        return service.makeMenuTable();
    }
    public Messenger removeMenuTable(){
        return service.removeTable();
    }

    public List<?> getMenusByCategory(String category){
        return service.getMenusByCategory(category);
    }

//    public Messenger returnMessenger() throws SQLException {
//        return service.returnMessenger();
//    }

    public List<?> returnAllMenus(String category) throws SQLException {
        return service.returnAllMenus(category);
    }
}
