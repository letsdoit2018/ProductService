//package com.letsdoit.core.product.service;
//
//import com.letsdoit.core.product.domain.Variants;
//import com.letsdoit.core.product.repository.VariantsRepository;
//import com.letsdoit.core.product.service.VariantsService;
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
//public class VariantsServiceTest {
//
//    @Mock
//    private VariantsRepository variantsRepository;
//
//    @InjectMocks
//    private VariantsService variantsService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testGetAllVariants() {
//        Variants variant = new Variants("1", "Variant1", "Description1");
//        when(variantsRepository.findAll()).thenReturn(Flux.just(variant));
//
//        Flux<Variants> variantsFlux = variantsService.getAllVariants();
//
//        StepVerifier.create(variantsFlux)
//                .expectNext(variant)
//                .verifyComplete();
//    }
//
//    @Test
//    void testGetVariantsById() {
//        Variants variant = new Variants("1", "Variant1", "Description1");
//        when(variantsRepository.findById("1")).thenReturn(Mono.just(variant));
//
//        Mono<Variants> variantsMono = variantsService.getVariantsById("1");
//
//        StepVerifier.create(variantsMono)
//                .expectNext(variant)
//                .verifyComplete();
//    }
//
//    @Test
//    void testGetVariantsByIdNotFound() {
//        when(variantsRepository.findById("1")).thenReturn(Mono.empty());
//
//        Mono<Variants> variantsMono = variantsService.getVariantsById("1");
//
//        StepVerifier.create(variantsMono)
//                .expectErrorMessage("Variants not found")
//                .verify();
//    }
//
//    @Test
//    void testInsertVariants() {
//        Variants variant = new Variants("1", "Variant1", "Description1");
//        when(variantsRepository.insert(any(Variants.class))).thenReturn(Mono.just(variant));
//
//        Mono<Variants> variantsMono = variantsService.insertVariants(Mono.just(variant));
//
//        StepVerifier.create(variantsMono)
//                .expectNext(variant)
//                .verifyComplete();
//    }
//
//    @Test
//    void testUpdateVariants() {
//        Variants existingVariant = new Variants("1", "Variant1", "Description1");
//        Variants updatedVariant = new Variants("1", "UpdatedVariant", "UpdatedDescription");
//        when(variantsRepository.findById("1")).thenReturn(Mono.just(existingVariant));
//        when(variantsRepository.save(any(Variants.class))).thenReturn(Mono.just(updatedVariant));
//
//        Mono<Variants> variantsMono = variantsService.updateVariants("1", Mono.just(updatedVariant));
//
//        StepVerifier.create(variantsMono)
//                .expectNext(updatedVariant)
//                .verifyComplete();
//    }
//
//    @Test
//    void testDeleteVariants() {
//        when(variantsRepository.deleteById("1")).thenReturn(Mono.empty());
//
//        Mono<Void> voidMono = variantsService.deleteVariants("1");
//
//        StepVerifier.create(voidMono)
//                .verifyComplete();
//    }
//}
