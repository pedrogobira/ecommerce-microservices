package com.pedrogobira.productcatalog.controller;

import com.pedrogobira.productcatalog.dto.ProductDto;
import com.pedrogobira.productcatalog.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<ProductDto> save(@RequestBody @Valid ProductDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }
}
