package com.pedrogobira.shoppingcart.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("cart")
public class Cart {
    @Id
    private Long id;
    private List<Item> items;

    public Cart(Long id) {
        this.id = id;
    }
}
