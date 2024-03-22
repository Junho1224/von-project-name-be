package com.von.api.user;
<<<<<<< HEAD

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
=======
import com.von.api.order.Order;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@ToString(exclude = {"id"})
@Entity(name="users")
public class User {
    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
>>>>>>> dev-jws
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private List<Order> orders;

    @Column
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="passwordConfirm")
    private String passwordConfirm;

    @Column(name="name")
    private String name;

    @Column(name="phone")
    private String phone;

    @Column(name="addressId")
    private Long addressId;

    @Column(name="job")
    private String job;

    @Column(name="height")
    private double height;

    @Column(name="weight")
    private double weight;

    @Builder(builderMethodName = "builder")
    public User(Long id, String username, String password, String passwordConfirm, String name,  String phone,
                String job, double height, double weight){
        this.id = id;
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
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
        return  "{username=" + username + '\n' +
                " password=" + password + '\n' +
                " name=" + name + '\n' +
                " phoneNumber=" + phone + '\n' +
                " job=" + job +
                '}'+'\n'+'\n';
    }
}
