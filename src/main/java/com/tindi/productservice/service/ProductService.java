package com.tindi.productservice.service;

import com.tindi.productservice.domain.ProductDomain;
import com.tindi.productservice.repository.ProductRepository;
import com.tindi.productservice.util.EntityDomainUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Flux<ProductDomain> getAllProducts() {
        return this.productRepository.findAll()
                .map(EntityDomainUtil::toDomain);
    }

    public Mono<ProductDomain> getProductById(String id) {
        return this.productRepository.findById(id)
                .map(EntityDomainUtil::toDomain);
    }

    public Mono<ProductDomain> insertProduct(Mono<ProductDomain> productDomainMono) {
        return productDomainMono.map(EntityDomainUtil::toEntity)
                .flatMap(product -> this.productRepository.insert(product))
                .map(EntityDomainUtil::toDomain);
    }

    public Mono<ProductDomain> updateProduct(String id, Mono<ProductDomain> productDomainMono){
        return this.productRepository.findById(id)
                .flatMap(product -> productDomainMono
                            .map(EntityDomainUtil::toEntity)
                            .doOnNext(product1 -> product1.setId(id))
                        .flatMap(this.productRepository::save)
                        .map(EntityDomainUtil::toDomain));
    }

    public Mono<Void> deleteProduct(String id){
        return this.productRepository.deleteById(id);
    }
}
