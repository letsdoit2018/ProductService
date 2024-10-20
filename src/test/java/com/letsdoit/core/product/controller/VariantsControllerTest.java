//package com.letsdoit.core.product.controller;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.reactive.server.WebTestClient;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import com.letsdoit.core.product.domain.Variants;
//import com.letsdoit.core.product.service.VariantsService;
//
//@WebFluxTest(VariantsController.class)
//public class VariantsControllerTest {
//
//    @Autowired
//    private WebTestClient webTestClient;
//
//    @MockBean
//    private VariantsService variantsService;
//
//    @Test
//    void testGetAllVariants() {
//        Variants variant = new Variants("1", "Variant1", "Description1");
//        Mockito.when(variantsService.getAllVariants()).thenReturn(Flux.just(variant));
//
//        webTestClient.get().uri("/all")
//                .accept(MediaType.APPLICATION_JSON)
//                .exchange()
//                .expectStatus().isOk()
//                .expectBodyList(Variants.class)
//                .hasSize(1)
//                .contains(variant);
//    }
//
//    @Test
//    void testGetVariantsById() {
//        Variants variant = new Variants("1", "Variant1", "Description1");
//        Mockito.when(variantsService.getVariantsById("1")).thenReturn(Mono.just(variant));
//
//        webTestClient.get().uri("/1")
//                .accept(MediaType.APPLICATION_JSON)
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody(Variants.class)
//                .isEqualTo(variant);
//    }
//
//    @Test
//    void testInsertVariants() {
//        Variants variant = new Variants("1", "Variant1", "Description1");
//        Mockito.when(variantsService.insertVariants(Mockito.any(Mono.class))).thenReturn(Mono.just(variant));
//
//        webTestClient.post().uri("/")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(variant)
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody(Variants.class)
//                .isEqualTo(variant);
//    }
//
//    @Test
//    void testUpdateVariants() {
//        Variants variant = new Variants("1", "UpdatedVariant", "UpdatedDescription");
//        Mockito.when(variantsService.updateVariants(Mockito.eq("1"), Mockito.any(Mono.class))).thenReturn(Mono.just(variant));
//
//        webTestClient.put().uri("/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(variant)
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody(Variants.class)
//                .isEqualTo(variant);
//    }
//
//    @Test
//    void testDeleteVariants() {
//        Mockito.when(variantsService.deleteVariants("1")).thenReturn(Mono.empty());
//
//        webTestClient.delete().uri("/1")
//                .exchange()
//                .expectStatus().isOk();
//    }
//}
