package com.von.api.account;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class Account {

        private long id;
        private String accountNumber;
        private String accountHolder;
        private double balance;
        private String transactionDate;


        @Builder(builderMethodName = "builder")
        public Account(long id, String accountNumber, String accountHolder, double balance, String transactionDate){
                this.id = id;
                this.accountNumber = accountNumber;
                this.accountHolder = accountHolder;
                this.balance = balance;
                this.transactionDate = transactionDate;


        }
        //TH

}



