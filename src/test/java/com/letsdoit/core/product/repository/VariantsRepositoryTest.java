//package com.letsdoit.core.product.repository;
//
//import com.letsdoit.core.product.domain.Variants;
//import com.letsdoit.core.product.repository.VariantsRepository;
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
//public class VariantsRepositoryTest {
//
//    @Autowired
//    private VariantsRepository variantsRepository;
//
//    private Variants variant;
//
//    @BeforeEach
//    void setUp() {
//        variant = new Variants("1", "Variant1", "Description1");
//        variantsRepository.deleteAll().block();
//        variantsRepository.save(variant).block();
//    }
//
//    @Test
//    void testFindAll() {
//        Flux<Variants> variantsFlux = variantsRepository.findAll();
//
//        StepVerifier.create(variantsFlux)
//                .expectNext(variant)
//                .verifyComplete();
//    }
//
//    @Test
//    void testFindById() {
//        Mono<Variants> variantsMono = variantsRepository.findById("1");
//
//        StepVerifier.create(variantsMono)
//                .expectNext(variant)
//                .verifyComplete();
//    }
//
//    @Test
//    void testInsert() {
//        Variants newVariant = new Variants("2", "Variant2", "Description2");
//        Mono<Variants> variantsMono = variantsRepository.save(newVariant);
//
//        StepVerifier.create(variantsMono)
//                .expectNext(newVariant)
//                .verifyComplete();
//    }
//
//    @Test
//    void testSave() {
//        variant.setName("UpdatedVariant");
//        Mono<Variants> variantsMono = variantsRepository.save(variant);
//
//        StepVerifier.create(variantsMono)
//                .expectNext(variant)
//                .verifyComplete();
//    }
//
//    @Test
//    void testDeleteById() {
//        Mono<Void> voidMono = variantsRepository.deleteById("1");
//
//        StepVerifier.create(voidMono)
//                .verifyComplete();
//
//        StepVerifier.create(variantsRepository.findById("1"))
//                .expectNextCount(0)
//                .verifyComplete();
//    }
//}
