package com.tindi.productservice.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDomain {
    private String id;
    private String description;
    private double price;
}
