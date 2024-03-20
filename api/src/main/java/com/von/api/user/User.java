package com.von.api.user;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class User {
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
