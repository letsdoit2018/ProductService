package com.letsdoit.core.product.repository;

import com.letsdoit.core.product.domain.Variants;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface VariantsRepository extends ReactiveMongoRepository<Variants, String> {
}
