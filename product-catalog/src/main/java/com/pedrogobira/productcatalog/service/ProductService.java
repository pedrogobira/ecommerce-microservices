package com.pedrogobira.productcatalog.service;

import com.pedrogobira.productcatalog.dto.ProductDto;
import com.pedrogobira.productcatalog.entity.Product;
import com.pedrogobira.productcatalog.mapper.ProductMapper;
import com.pedrogobira.productcatalog.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper = ProductMapper.INSTANCE;

    @Transactional
    public ProductDto save(ProductDto dto) {
        if (isSaved(dto.getName())) throw new IllegalArgumentException();
        Product product = mapper.toEntity(dto);
        product = repository.save(product);
        return mapper.toDto(product);
    }

    @Transactional(readOnly = true)
    public List<ProductDto> findAll() {
        Iterable<Product> iterable = repository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProductDto findById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    private boolean isSaved(String name) {
        return repository.findByName(name).isPresent();
    }
}
