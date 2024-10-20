//package com.letsdoit.core.product.repository;
//
//import com.letsdoit.core.product.domain.PartnerProductCategory;
//import com.letsdoit.core.product.repository.PartnerProductCategoryRepository;
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
//public class PartnerProductCategoryRepositoryTest {
//
//    @Autowired
//    private PartnerProductCategoryRepository partnerProductCategoryRepository;
//
//    private PartnerProductCategory category;
//
//    @BeforeEach
//    void setUp() {
//        category = new PartnerProductCategory("1", "Category1", "Description1");
//        partnerProductCategoryRepository.deleteAll().block();
//        partnerProductCategoryRepository.save(category).block();
//    }
//
//    @Test
//    void testFindAll() {
//        Flux<PartnerProductCategory> categoryFlux = partnerProductCategoryRepository.findAll();
//
//        StepVerifier.create(categoryFlux)
//                .expectNext(category)
//                .verifyComplete();
//    }
//
//    @Test
//    void testFindById() {
//        Mono<PartnerProductCategory> categoryMono = partnerProductCategoryRepository.findById("1");
//
//        StepVerifier.create(categoryMono)
//                .expectNext(category)
//                .verifyComplete();
//    }
//
//    @Test
//    void testInsert() {
//        PartnerProductCategory newCategory = new PartnerProductCategory("2", "Category2", "Description2");
//        Mono<PartnerProductCategory> categoryMono = partnerProductCategoryRepository.save(newCategory);
//
//        StepVerifier.create(categoryMono)
//                .expectNext(newCategory)
//                .verifyComplete();
//    }
//
//    @Test
//    void testSave() {
//        category.setName("UpdatedCategory");
//        Mono<PartnerProductCategory> categoryMono = partnerProductCategoryRepository.save(category);
//
//        StepVerifier.create(categoryMono)
//                .expectNext(category)
//                .verifyComplete();
//    }
//
//    @Test
//    void testDeleteById() {
//        Mono<Void> voidMono = partnerProductCategoryRepository.deleteById("1");
//
//        StepVerifier.create(voidMono)
//                .verifyComplete();
//
//        StepVerifier.create(partnerProductCategoryRepository.findById("1"))
//                .expectNextCount(0)
//                .verifyComplete();
//    }
//}
