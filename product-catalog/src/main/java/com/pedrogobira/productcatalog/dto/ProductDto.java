package com.pedrogobira.productcatalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    @Id
    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Integer amount;
}
