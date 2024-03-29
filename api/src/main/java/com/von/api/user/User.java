package com.von.api.user;

import java.util.List;

import com.von.api.article.Article;
import com.von.api.order.Order;
import com.von.api.product.Product;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
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

    @OneToMany(mappedBy = "writer")
    private List<Article> articlesId;

    // @OneToMany(mappedBy = "user")
    // private List<Order> ordersId;



   

   
}