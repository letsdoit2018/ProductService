package com.tindi.productservice.util;

import com.tindi.productservice.domain.ProductDomain;
import com.tindi.productservice.entity.Product;
public class EntityDomainUtil {
    public static ProductDomain toDomain(Product product){
        return ProductDomain.builder()
                .id(product.getId())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public static Product toEntity(ProductDomain productDomain){
        return Product.builder()
                .id(productDomain.getId())
                .description(productDomain.getDescription())
                .price(productDomain.getPrice())
                .build();
    }
}
