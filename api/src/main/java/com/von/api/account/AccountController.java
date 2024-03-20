package com.von.api.account;


import com.von.api.enums.Messenger;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountServiceImpl acServ;

    public Messenger createAccount(Scanner scan) {
        System.out.println("id, acNum, acH, bal");
        return acServ.save(Account.builder()
                .id(scan.nextLong())
                .accountNumber(scan.next())
                .accountHolder(scan.next())
                .balance(scan.nextDouble())
                .transactionDate(LocalDate.now())
                .build());
    }

    public String deposit(Scanner scan) {
        return acServ.deposit(Account.builder()
                .id(scan.nextLong())
                .accountNumber(scan.next())
                .accountHolder(scan.next())
                .balance(scan.nextDouble())
                .transactionDate(null)
                .build());
    }

    public String withdraw(Scanner scan) {
        return acServ.withdraw(Account.builder()
                .id(scan.nextLong())
                .accountNumber(scan.next())
                .accountHolder(scan.next())
                .balance(scan.nextDouble())
                .transactionDate(null)
                .build());
    }

    public String getBalance(Scanner scan) {
        return acServ.getBalance(scan.next());
    }

    public String cancelAccount(Scanner scan) {
        System.out.println("Insert accountNumber to remove");
        return acServ.delete(Account.builder().accountNumber(scan.next()).build());
    }

    public List<?> getAccounts() {
        return acServ.findAll();
    }
}
