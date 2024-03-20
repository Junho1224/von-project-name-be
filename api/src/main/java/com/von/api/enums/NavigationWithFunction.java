package com.von.api.enums;

import com.von.api.account.AccountView;
import com.von.api.board.BoardView;
import com.von.api.crawling.CrawlerView;
import com.von.api.user.User;
import com.von.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum NavigationWithFunction {

    EXIT("exit", i -> "x"),
    USER("user", i ->{
        try {
            UserView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    BOARD("board", i -> {
        BoardView.main();
        return null;
    }),
    ACCOUNT("account", i ->{
        AccountView.main(i);
        return null;
    }),
    CRAWLER("crawler", i -> {
        try {
            CrawlerView.main(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }),

    ;
    private final String name;
    private final Function<Scanner, String> function;

    NavigationWithFunction(String name, Function<Scanner, String> function) {
        this.name = name;
        this.function = function;
    }


    public static String navigate(Scanner sc) {
        System.out.println("\n === " +
                "x-Exit +" +
                "u-User " +
                "b-Board " +
                "ac-Account " +
                "c-Crawler " +
                "ar-Articles" +
                "===");
        String navigateMenu = sc.next();
        System.out.println("선택한 메뉴 : " + navigateMenu);

        return Stream.of(values())
                .filter(i->i.name.equals(navigateMenu))
                .findAny()
                .orElseGet(()->EXIT)
                .function.apply(sc);


    }



}

