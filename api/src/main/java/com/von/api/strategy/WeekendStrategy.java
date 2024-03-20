package com.von.api.strategy;

import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.*;

public enum WeekendStrategy {
    SUNDAY("1", i -> "일요일"),
    MONDAY("2", i-> "월요일"),
    TUESDAY("3", i-> "화요일"),
    WEDNESDAY("4", i-> "수요일"),
    THURSDAY("5", i-> "목요일"),
    FRIDAY("6", i-> "금요일"),
    SATURDAY("7", i-> "토요일"),
    Wrong("x",i -> "Wrong")
    ;


    private final String name;
    private final Function<String,String> function;

    WeekendStrategy(String name, Function<String, String> function) {
        this.name = name;
        this.function = function;
    }

    public static String extracted(Scanner sc) {
        System.out.println("1~7 입력:");
        String s = sc.next();
        return Stream.of(values())
                .filter(i -> i.name.equals(s))
                .findAny().orElseGet(()->Wrong)
                .function.apply(s) //
                ;
    }
}
