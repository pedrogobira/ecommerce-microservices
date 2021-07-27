package com.pedrogobira.shoppingcart.entities;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash("item")
public class Item {
    private Long productId;
    private Integer amount;
}
