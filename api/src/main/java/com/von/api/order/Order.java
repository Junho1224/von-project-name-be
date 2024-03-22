package com.von.api.order;

<<<<<<< HEAD
import com.von.api.product.Product;
import com.von.api.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})

@Entity(name = "orders")
public class Order {

    @Id
    @Column(name = "orderId", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private LocalDate orderDate;

    private Integer orderAmount;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder(builderMethodName = "builder")

    public Order(Long id, LocalDate orderDate, Integer orderAmount, Product product, User user) {
        this.id = id;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
        this.product = product;
        this.user = user;
=======
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"id"})
@Entity(name="order_table")
public class Order {

    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    @Builder
    public Order(Long id) {
        this.id = id;
>>>>>>> dev-jws
    }
}
