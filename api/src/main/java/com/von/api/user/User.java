package com.von.api.user;

import java.util.List;

import com.von.api.article.Article;
import com.von.api.product.Product;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = { "id" })
public class User {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String addressId;
    private String job;
    private double height;
    private double weight;


    @Builder(builderMethodName = "builder")
    public User(Long id, String username, String password, String addressId,
            String name, String phone,
            String job,
            double height, double weight) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.addressId = addressId;
        this.name = name;
        this.phone = phone;
        this.job = job;
        this.height = height;
        this.weight = weight;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{\n" +
                "username='" + username + '\n' +
                ", password='" + password + '\n' +
                ", name='" + name + '\n' +
                ", phoneNumber='" + phone + '\n' +
                ", job='" + job + '\n' +
                '}';
    }
}