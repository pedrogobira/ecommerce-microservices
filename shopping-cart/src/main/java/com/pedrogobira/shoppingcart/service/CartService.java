package com.pedrogobira.shoppingcart.service;

import com.pedrogobira.shoppingcart.entities.Cart;
import com.pedrogobira.shoppingcart.entities.Item;
import com.pedrogobira.shoppingcart.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CartService {

    private final CartRepository repository;

    @Transactional
    public Cart addItem(Long id, Item item) {
        Cart cart = repository.findById(id).orElse(new Cart(id));
        cart.getItems().add(item);
        return repository.save(cart);
    }

    public Cart findById(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void clear(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }
}
