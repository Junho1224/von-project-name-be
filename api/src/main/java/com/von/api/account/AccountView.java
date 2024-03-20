package com.von.api.account;


import java.util.Scanner;

public class AccountView {

    public static void main(Scanner sc) {
        AccountController ctrl = new AccountController();

        while (true){
            System.out.println("[사용자 메뉴] 0-종료\n" +
                    "1-계좌 만들기\n" +
                    "2-예금\n" +
                    "3-출금\n" +
                    "4-잔액\n" +
                    "5-해지");
            switch (sc.next()){
                case "0":
                    System.out.println("0-종료");
                    return;
                case "1":
                    System.out.println("1-Create Account");
                    System.out.println(ctrl.createAccount(sc));
                    break;

                case "2":
                    System.out.println("2-Deposit");
                    System.out.println(ctrl.deposit(sc));
                case "3":
                    System.out.println("3-Withdraw");
                    System.out.println(ctrl.withdraw(sc));
                case "4":
                    System.out.println("4-Balance");
                    String temp = ctrl.getbalance(sc);
                case "5":
                    System.out.println("5-Cancel Account");
                    System.out.println(ctrl.delete(sc));
                case  "6":
                    System.out.println("5-Account List");

            }

        }



    }
}
