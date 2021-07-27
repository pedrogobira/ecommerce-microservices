package com.pedrogobira.productcatalog.repository;

import com.pedrogobira.productcatalog.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface ProductRepository extends ElasticsearchRepository<Product, Long> {
    Optional<Product> findByName(String name);
}
