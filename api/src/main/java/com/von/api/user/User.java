package com.von.api.user;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString

@Entity(name = "users")
public class User {

    @Id
    @Column(name = "userId",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String password;
    private String name;
    private String pNum;
    private String job;
    private Double height;
    private Double weight;

    @Builder(builderMethodName = "builder")
    public User(Long id, String userName, String password
            , String name, String pNum, String job
            , Double height, Double weight) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.pNum = pNum;
        this.job = job;
        this.height = height;
        this.weight = weight;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}