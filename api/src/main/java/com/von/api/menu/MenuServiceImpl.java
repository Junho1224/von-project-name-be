package com.von.api.menu;

import com.von.api.enums.Messenger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService{
    private final MenuRepository repository;

    @Override
    public Messenger makeMenuTable(){
        repository.makeTable();
        this.insertMenus();
        return Messenger.SUCCESS;
    }

    @Override
    public Messenger removeTable() {
        return repository.removeTable();
    }

    @Override
    public List<?> getMenusByCategory(String category) {
        return repository.getMenusByCategory(category);
    }

//    @Override
//    public Messenger returnMessenger() {
//        return repository.returnMessenger();
//    }

    @Override
    public List<?> returnAllMenus(String category) throws SQLException {
        return repository.returnAllMenus(category);
    }

    /**
     * 공통 메뉴 명령어 정의
     * x means 'Exit'
     * mk means 'Create Table'
     * cat means 'Find The One'
     * touch means 'Insert One'
     * ch-* means 'Change What'
     * rm means 'Delete Row'
     * ls-a means 'All List'
     * ls-n means 'Find By Name'
     * ls-* means 'Something List'
     * cnt means 'Count'
     * 이 외에 일상적이 아닌 단어는 약어 사용
     * withdraw -> with
     * deposit -> depo
     * balance -> bal
     * */
    private void insertMenus(){
        String[] categories = {"navigate", "user", "account", "article", "board", "soccer"};
        String[][] menus = {{"x", "usr", "acc", "cwl", "art", "bbs","scc"},
                {"x", "mk", "joi", "log", "cat", "ch-pw", "rm",
                        "ls-a", "ls-n", "ls-job", "cnt"},
                {"x", "mk", "touch", "with", "depo", "bal", "rm", "cat", "ls-a"},
                {"x", "mk"},
                {"x", "mk"},
                {"x", "mk"},
        };

        for(int i = 0; i < menus.length; i++)
            for(int j = 0; j < menus[i].length; j++)
                repository.insertMenu(Menu.builder().category(categories[i]).item(menus[i][j]).build());
    }
}
