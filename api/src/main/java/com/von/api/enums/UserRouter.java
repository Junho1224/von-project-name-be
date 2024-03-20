package com.von.api.enums;

import com.von.api.menu.Menu;
import com.von.api.user.UserController;

import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum UserRouter {

    EXIT("x", i -> "Exit"),
    SAVE("join", i ->{
        return UserController.getInstance().save(i);

    }),
    LOGIN("login", i ->{
        return UserController.getInstance().login(i);
    }),
    GETONE("findId", i -> {
        System.out.println(UserController.getInstance().getOne(i));
       return "";
    }),
    UDP("updatePw", i ->{
        System.out.println(UserController.getInstance().updatePassword(i));
        return "";
    }),
    DELETE("delete", i ->{
        System.out.println(UserController.getInstance().delete(i));
        return "";
    }),

    GUM("list", i ->{
        return "회원목록";
    }),
    FUBN("searchName", i ->{
        return "이름검색";


    }),
    FUBJ("searchJob", i ->{
        return "직업 검색";
    }),

    COUNT("count", i ->{
        return "회원수";
    }),
    CREATU("touch", i -> "true"),
    ;


    private final String name;
    private final Function<Scanner, String> function;

    UserRouter(String name, Function<Scanner, String> function) {
        this.name = name;
        this.function = function;
    }

    public static String extracted(Scanner sc) {
        Menu menu = null;

        System.out.println("[사용자메뉴] 0-종료\n " +
                "1-회원가입\n " +
                "2-로그인\n " +
                "3-ID검색\n " +
                "4-비번변경\n" +
                "5-탈퇴\n " +
                "6-회원목록\n " +
                "7-이름검색\n" +
                "8-직업검색\n" +
                "9-회원수" +
                "touch-테이블생성\n" +
                "rm-테이블삭제" +
                "");
        String s = sc.next();

        return Stream.of(values())
                .filter(i -> i.name.equals(s))
                .findAny().orElse(EXIT)
                .function.apply(sc)
                ;
    }
}


