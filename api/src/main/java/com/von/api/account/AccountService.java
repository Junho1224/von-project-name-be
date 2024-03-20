package com.von.api.account;


public interface AccountService {
    String deposit(Account dto);
    String withdraw(Account dto);
    String getBalance(String accountNumber);
}
