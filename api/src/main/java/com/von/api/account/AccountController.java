package com.von.api.account;
import com.von.api.enums.Messenger;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class AccountController {

    LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    String strNowDate = formatter.format(today);

    AccountServiceImpl user;

    public AccountController() {
        this.user = AccountServiceImpl.getInstance();
    }

    public Messenger createAccount(Scanner scanner) {
        System.out.println("ID" +
                "계좌번호" +
                "계좌 홀더?" +
                "발란스?"
        );
        return user.save(Account.builder()
                .id(sc.nextLong())
                .accountNumber(sc.next())
                .accountHolder(sc.next())
                .balance(sc.nextDouble())
                .transactionDate(strNowDate) //date
                .build());
    }


    public String deposit(Scanner sc) {
        return user.deposit(Account.builder()
                .id(sc.nextLong())
                .accountHolder(sc.next())
                .accountNumber(sc.next())
                .balance(sc.nextDouble())
                .transactionDate(null) //date
                .build());
    }

    public String withdraw(Scanner sc) {
        return user.withdraw(Account.builder()
                .id(sc.nextLong())
                .accountHolder(sc.next())
                .accountNumber(sc.next())
                .balance(sc.nextDouble())
                .transactionDate(null) //date
                .build());
    }

    public String getbalance(Scanner sc) {
        return user.getBalance(sc.next());
    }

    public String delete(Scanner sc) {
        return user.delete(Account.builder()
                .accountNumber(sc.next())
                .build());
    }


    public List<?> getAccounts() {
        return user.findAll();
    }


}
