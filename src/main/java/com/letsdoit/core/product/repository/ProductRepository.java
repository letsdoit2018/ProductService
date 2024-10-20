package com.letsdoit.core.product.repository;

import com.letsdoit.core.product.domain.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends ReactiveMongoRepository<Product, String> {
}
