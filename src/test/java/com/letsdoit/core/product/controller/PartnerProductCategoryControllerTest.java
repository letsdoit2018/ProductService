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
//import com.letsdoit.core.product.domain.PartnerProductCategory;
//import com.letsdoit.core.product.service.PartnerProductCategoryService;
//
//@WebFluxTest(PartnerProductCategoryController.class)
//public class PartnerProductCategoryControllerTest {
//
//    @Autowired
//    private WebTestClient webTestClient;
//
//    @MockBean
//    private PartnerProductCategoryService partnerProductCategoryService;
//
//    @Test
//    void testGetAllPartnerProductCategories() {
//        PartnerProductCategory category = new PartnerProductCategory("1", "Category1", "Description1");
//        Mockito.when(partnerProductCategoryService.getAllPartnerProductCategories()).thenReturn(Flux.just(category));
//
//        webTestClient.get().uri("/all")
//                .accept(MediaType.APPLICATION_JSON)
//                .exchange()
//                .expectStatus().isOk()
//                .expectBodyList(PartnerProductCategory.class)
//                .hasSize(1)
//                .contains(category);
//    }
//
//    @Test
//    void testGetPartnerProductCategoryById() {
//        PartnerProductCategory category = new PartnerProductCategory("1", "Category1", "Description1");
//        Mockito.when(partnerProductCategoryService.getPartnerProductCategoryById("1")).thenReturn(Mono.just(category));
//
//        webTestClient.get().uri("/1")
//                .accept(MediaType.APPLICATION_JSON)
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody(PartnerProductCategory.class)
//                .isEqualTo(category);
//    }
//
//    @Test
//    void testInsertPartnerProductCategory() {
//        PartnerProductCategory category = new PartnerProductCategory("1", "Category1", "Description1");
//        Mockito.when(partnerProductCategoryService.insertPartnerProductCategory(Mockito.any(Mono.class))).thenReturn(Mono.just(category));
//
//        webTestClient.post().uri("/")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(category)
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody(PartnerProductCategory.class)
//                .isEqualTo(category);
//    }
//
//    @Test
//    void testUpdatePartnerProductCategory() {
//        PartnerProductCategory category = new PartnerProductCategory("1", "UpdatedCategory", "UpdatedDescription");
//        Mockito.when(partnerProductCategoryService.updatePartnerProductCategory(Mockito.eq("1"), Mockito.any(Mono.class))).thenReturn(Mono.just(category));
//
//        webTestClient.put().uri("/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(category)
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody(PartnerProductCategory.class)
//                .isEqualTo(category);
//    }
//
//    @Test
//    void testDeletePartnerProductCategory() {
//        Mockito.when(partnerProductCategoryService.deletePartnerProductCategory("1")).thenReturn(Mono.empty());
//
//        webTestClient.delete().uri("/1")
//                .exchange()
//                .expectStatus().isOk();
//    }
//}
