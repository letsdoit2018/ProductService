package com.letsdoit.core.product.service;

import com.letsdoit.core.product.domain.Product;
import com.letsdoit.core.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Flux<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    //What should be done here for product not found?
    public Mono<Product> getProductById(String id) {
        return this.productRepository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("Product not found")));
    }

    public Mono<Product> insertProduct(Mono<Product> productMono) {
        return productMono
                .flatMap(product -> this.productRepository.insert(product));
    }

    public Mono<Product> updateProduct(String id, Mono<Product> productMono){
        return this.productRepository.findById(id)
                .flatMap(product -> productMono
                            .doOnNext(product1 -> product1.setId(id))
                        .flatMap(this.productRepository::save));
    }

    public Mono<Void> deleteProduct(String id){
        return this.productRepository.deleteById(id);
    }
}
