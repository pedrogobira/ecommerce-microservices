package com.pedrogobira.shoppingcart.controller;

import com.pedrogobira.shoppingcart.entities.Cart;
import com.pedrogobira.shoppingcart.entities.Item;
import com.pedrogobira.shoppingcart.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/cart")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CartController {

    private CartService service;

    @PostMapping("/{id}")
    public ResponseEntity<Cart> addItem(@PathVariable Long id, @RequestBody Item item) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addItem(id, item));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> clear(@PathVariable Long id) {
        service.clear(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}