package com.pedrogobira.shoppingcart.repository;

import com.pedrogobira.shoppingcart.entities.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
    Cart findByCustomerId(Integer customerId);
}
