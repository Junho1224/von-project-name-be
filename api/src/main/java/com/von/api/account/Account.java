//package com.von.api.account;
//
//import lombok.*;
//
//import java.time.LocalDate;
//import jakarta.persistence.*;
//
//
//@Entity(name = "account")
//@NoArgsConstructor (access = AccessLevel.PROTECTED)
//@Getter
//@ToString (exclude = {"id"})
//
//public class Account {
//
//    @Id
//    @Column(name = "id", nullable = false)
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    private String accountNumber;
//    private String accountHolder;
//    private Double balance;
//    private LocalDate transactionDate;
//
//@Builder(builderMethodName = "builder")
//    public Account(Long id, String accountNumber, String accountHolder, Double balance, LocalDate transactionDate) {
//        this.id = id;
//        this.accountNumber = accountNumber;
//        this.accountHolder = accountHolder;
//        this.balance = balance;
//        this.transactionDate = transactionDate;
//    }
//}
