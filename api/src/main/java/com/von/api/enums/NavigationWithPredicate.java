package com.von.api.enums;

import com.von.api.account.AccountView;
import com.von.api.auth.AuthView;
import com.von.api.crawling.CrawlerView;
import com.von.api.menu.MenuController;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum NavigationWithPredicate {
    EXIT("x", i -> {
        System.out.println("EXIT");
        return false;
    }),
    USER("usr", i -> {
        try {
            UserView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    ACCOUNT("acc", i -> {
        AccountView.main(i);
        return true;
    }),
    CRAWLER("cwl", i -> {
        try {
            CrawlerView.main(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
//    POSTS("posts", i -> {
//        try {
//            PostView.main(i);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return true;
//    }),
    AUTH("auth", i -> {
    AuthView.main(i);
    return true;
    }),
    NAVIGATION_ERROR("navigation_error", i -> {
        System.out.println("Wrong Input");
        return true;
    });

    private final String name;
    private final Predicate<Scanner> predicate;

    NavigationWithPredicate(String name, Predicate<Scanner> predicate){
        this.name = name;
        this.predicate = predicate;
    }



    public static Boolean navigate(Scanner sc) throws SQLException {

        List<String> ls = MenuController.getInstance().userMenu();

        System.out.println("x-Exit," +
                " auth-Auth," +
                " acc-Account," +
                " cwl-Crawler," +
                " post-Post," +
                " usr-User");
        String selectMenu = sc.next();
        return Stream.of(values()).filter(i -> i.name.equals(selectMenu))
                .findAny().orElse(NAVIGATION_ERROR).predicate.test(sc); //Predicate이기 때문에 boolean test
    }


}