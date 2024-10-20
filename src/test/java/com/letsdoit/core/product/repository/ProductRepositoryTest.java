//package com.letsdoit.core.product.repository;
//
//import com.letsdoit.core.product.domain.Product;
//import com.letsdoit.core.product.repository.ProductRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.context.annotation.ComponentScan;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//import reactor.test.StepVerifier;
//
//@DataMongoTest
//@ComponentScan(basePackages = "com.letsdoit.core.product")
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class ProductRepositoryTest {
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    private Product product;
//
//    @BeforeEach
//    void setUp() {
//        product = new Product("1", "Product1", 100.0);
//        productRepository.deleteAll().block();
//        productRepository.save(product).block();
//    }
//
//    @Test
//    void testFindAll() {
//        Flux<Product> productFlux = productRepository.findAll();
//
//        StepVerifier.create(productFlux)
//                .expectNext(product)
//                .verifyComplete();
//    }
//
//    @Test
//    void testFindById() {
//        Mono<Product> productMono = productRepository.findById("1");
//
//        StepVerifier.create(productMono)
//                .expectNext(product)
//                .verifyComplete();
//    }
//
//    @Test
//    void testInsert() {
//        Product newProduct = new Product("2", "Product2", 200.0);
//        Mono<Product> productMono = productRepository.save(newProduct);
//
//        StepVerifier.create(productMono)
//                .expectNext(newProduct)
//                .verifyComplete();
//    }
//
//    @Test
//    void testSave() {
//        product.setName("UpdatedProduct");
//        Mono<Product> productMono = productRepository.save(product);
//
//        StepVerifier.create(productMono)
//                .expectNext(product)
//                .verifyComplete();
//    }
//
//    @Test
//    void testDeleteById() {
//        Mono<Void> voidMono = productRepository.deleteById("1");
//
//        StepVerifier.create(voidMono)
//                .verifyComplete();
//
//        StepVerifier.create(productRepository.findById("1"))
//                .expectNextCount(0)
//                .verifyComplete();
//    }
//}
