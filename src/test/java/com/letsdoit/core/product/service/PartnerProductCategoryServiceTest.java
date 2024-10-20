//package com.letsdoit.core.product.service;
//
//import com.letsdoit.core.product.domain.PartnerProductCategory;
//import com.letsdoit.core.product.repository.PartnerProductCategoryRepository;
//import com.letsdoit.core.product.service.PartnerProductCategoryService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//import reactor.test.StepVerifier;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//public class PartnerProductCategoryServiceTest {
//
//    @Mock
//    private PartnerProductCategoryRepository partnerProductCategoryRepository;
//
//    @InjectMocks
//    private PartnerProductCategoryService partnerProductCategoryService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testGetAllPartnerProductCategories() {
//        PartnerProductCategory category = new PartnerProductCategory("1", "Category1", "Description1");
//        when(partnerProductCategoryRepository.findAll()).thenReturn(Flux.just(category));
//
//        Flux<PartnerProductCategory> categoryFlux = partnerProductCategoryService.getAllPartnerProductCategories();
//
//        StepVerifier.create(categoryFlux)
//                .expectNext(category)
//                .verifyComplete();
//    }
//
//    @Test
//    void testGetPartnerProductCategoryById() {
//        PartnerProductCategory category = new PartnerProductCategory("1", "Category1", "Description1");
//        when(partnerProductCategoryRepository.findById("1")).thenReturn(Mono.just(category));
//
//        Mono<PartnerProductCategory> categoryMono = partnerProductCategoryService.getPartnerProductCategoryById("1");
//
//        StepVerifier.create(categoryMono)
//                .expectNext(category)
//                .verifyComplete();
//    }
//
//    @Test
//    void testGetPartnerProductCategoryByIdNotFound() {
//        when(partnerProductCategoryRepository.findById("1")).thenReturn(Mono.empty());
//
//        Mono<PartnerProductCategory> categoryMono = partnerProductCategoryService.getPartnerProductCategoryById("1");
//
//        StepVerifier.create(categoryMono)
//                .expectErrorMessage("PartnerProductCategory not found")
//                .verify();
//    }
//
//    @Test
//    void testInsertPartnerProductCategory() {
//        PartnerProductCategory category = new PartnerProductCategory("1", "Category1", "Description1");
//        when(partnerProductCategoryRepository.insert(any(PartnerProductCategory.class))).thenReturn(Mono.just(category));
//
//        Mono<PartnerProductCategory> categoryMono = partnerProductCategoryService.insertPartnerProductCategory(Mono.just(category));
//
//        StepVerifier.create(categoryMono)
//                .expectNext(category)
//                .verifyComplete();
//    }
//
//    @Test
//    void testUpdatePartnerProductCategory() {
//        PartnerProductCategory existingCategory = new PartnerProductCategory("1", "Category1", "Description1");
//        PartnerProductCategory updatedCategory = new PartnerProductCategory("1", "UpdatedCategory", "UpdatedDescription");
//        when(partnerProductCategoryRepository.findById("1")).thenReturn(Mono.just(existingCategory));
//        when(partnerProductCategoryRepository.save(any(PartnerProductCategory.class))).thenReturn(Mono.just(updatedCategory));
//
//        Mono<PartnerProductCategory> categoryMono = partnerProductCategoryService.updatePartnerProductCategory("1", Mono.just(updatedCategory));
//
//        StepVerifier.create(categoryMono)
//                .expectNext(updatedCategory)
//                .verifyComplete();
//    }
//
//    @Test
//    void testDeletePartnerProductCategory() {
//        when(partnerProductCategoryRepository.deleteById("1")).thenReturn(Mono.empty());
//
//        Mono<Void> voidMono = partnerProductCategoryService.deletePartnerProductCategory("1");
//
//        StepVerifier.create(voidMono)
//                .verifyComplete();
//    }
//}
