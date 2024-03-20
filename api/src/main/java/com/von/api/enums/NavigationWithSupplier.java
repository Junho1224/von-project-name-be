package com.von.api.enums;

import com.von.api.account.AccountView;
import com.von.api.board.BoardView;
import com.von.api.crawling.CrawlerView;
import com.von.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;

public enum NavigationWithSupplier {
//    EXIT("exit", i -> "x"),
//    USER("user", i ->{
//        try {
//            UserView.main(i);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return "";
//    }),
//    BOARD("board", i -> {
//        BoardView.main();
//        return null;
//    }),
//    ACCOUNT("account", i ->{
//        AccountView.main(i);
//        return null;
//    }),
//    CRAWLER("crawler", i -> {
//        try {
//            CrawlerView.main(i);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return null;
//    }),
//    ;


//    NavigationWithSupplier(String name, java.util.function.Supplier<String> supplier) {
//        this.name = name;
//        Supplier = supplier;
//    }
//
//    private final String name;
//    private final Supplier<String> Supplier;
//
//
//    ;
//
//    public static String navigate(Scanner sc) {
//        return "";
//    }
}
