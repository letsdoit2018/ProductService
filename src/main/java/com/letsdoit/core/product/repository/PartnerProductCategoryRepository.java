package com.letsdoit.core.product.repository;

import com.letsdoit.core.product.domain.PartnerProductCategory;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PartnerProductCategoryRepository extends ReactiveMongoRepository<PartnerProductCategory, String> {
}
