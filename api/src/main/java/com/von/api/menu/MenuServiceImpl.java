package com.von.api.menu;

import com.von.api.enums.Messenger;
import lombok.Getter;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class MenuServiceImpl implements MenuService{


    private static final MenuService instance = new MenuServiceImpl();
    public static MenuService getInstance(){
        return instance;
    }
    private final MenuRepository repo;

    private MenuServiceImpl(){
        repo = MenuRepository.getInstance();
    }


    @Override
    public Messenger makeMenuTable() {
        repo.makeTable();
        this.insertMenus();
        return Messenger.SUCCESS;
    }


    @Override
    public Messenger removeTable() {
        return repo.removeTable();
    }

    @Override
    public List<?> getMenusByCategory(String category) {
        return repo.getMenusByCategory(category);
    }

    @Override
    public Messenger createTable() {
        return null;
    }



    @Override
    public Messenger returnMessenger() throws SQLException {
        try {
            return repo.returnMessenger();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Map<String, ?> returnMap() throws SQLException {
        return repo.returnMap();
    }

    @Override
    public Menu drumgodum() {
        return null;
    }

    @Override
    public List<String> userMenu() throws SQLException {

        return repo.userMenu();
    }

    @Override
    public Menu returnOneMenu() {
        return repo.returnOneMenu();
    }

    @Override
    public List<?> returnAllMenus() throws SQLException {
        return null;
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
//        String[] categories = {"navigate", "user", "account", "crawler","auth", "football"};
//        String[][] menus = {{"x :Exit", "user :User", "account :Account", "crawl :Crawler","auth :Auth"},
//                {"x :종료", "mkdir :MakeUserTable", "join-회원가입", "login-로그인", "findId-ID 검색", "updatePw-PW 변경", "delete-탈퇴", "list-회원목록", "searchName-이름 검색", "searchJob-직업 검색", "count-회원수"},
//                {"0-Exit", "mkdir :MakeAccountTable","1-Create", "2-Withdraw", "3-Deposit", "4-Balance", "5-Delete", "6-Find", "7-List"},
//                {"0-종료", "1-벅스뮤직", "2-멜론"},
//                {"0-Exit","mkdir :MakeAuthTable","1-Auth"},
//                {"x :종료","1-football"}};
        String[] categories = {"navigate", "user", "account", "article", "board", "soccer"};
        String[][] menus = {{"x", "usr", "acc", "cwl", "art", "bbs","scc"},
                {"x", "mk", "joi", "log", "cat :", "ch-pw", "rm",
                        "ls-a", "ls-n", "ls-job", "cnt"},
                {"x", "mk", "touch", "with", "depo", "bal", "rm", "cat", "ls-a"},
                {"x", "mk"},
                {"x", "mk"},
                {"x", "mk"},
        };

        for(int i = 0; i < menus.length; i++)
            for(int j = 0; j < menus[i].length; j++)
                repo.insertMenu(Menu.builder()
                        .category(categories[i])
                        .item(menus[i][j])
                        .build());
    }
}
