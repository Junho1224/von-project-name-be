package com.von.api.order;

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
    }
}
