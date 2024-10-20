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
//import com.letsdoit.core.product.domain.Product;
//import com.letsdoit.core.product.service.ProductService;
//
//@WebFluxTest(ProductController.class)
//public class ProductControllerTest {
//
//    @Autowired
//    private WebTestClient webTestClient;
//
//    @MockBean
//    private ProductService productService;
//
//    @Test
//    void testGetAllProducts() {
//        Product product = new Product("1", "Product1", 100.0);
//        Mockito.when(productService.getAllProducts()).thenReturn(Flux.just(product));
//
//        webTestClient.get().uri("/product/all")
//                .accept(MediaType.APPLICATION_JSON)
//                .exchange()
//                .expectStatus().isOk()
//                .expectBodyList(Product.class)
//                .hasSize(1)
//                .contains(product);
//    }
//
//    @Test
//    void testGetProductById() {
//        Product product = new Product("1", "Product1", 100.0);
//        Mockito.when(productService.getProductById("1")).thenReturn(Mono.just(product));
//
//        webTestClient.get().uri("/product/1")
//                .accept(MediaType.APPLICATION_JSON)
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody(Product.class)
//                .isEqualTo(product);
//    }
//
//    @Test
//    void testInsertProduct() {
//        Product product = new Product("1", "Product1", 100.0);
//        Mockito.when(productService.insertProduct(Mockito.any(Mono.class))).thenReturn(Mono.just(product));
//
//        webTestClient.post().uri("/product")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(product)
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody(Product.class)
//                .isEqualTo(product);
//    }
//
//    @Test
//    void testUpdateProduct() {
//        Product product = new Product("1", "UpdatedProduct", 150.0);
//        Mockito.when(productService.updateProduct(Mockito.eq("1"), Mockito.any(Mono.class))).thenReturn(Mono.just(product));
//
//        webTestClient.put().uri("/product/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(product)
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody(Product.class)
//                .isEqualTo(product);
//    }
//
//    @Test
//    void testDeleteProduct() {
//        Mockito.when(productService.deleteProduct("1")).thenReturn(Mono.empty());
//
//        webTestClient.delete().uri("/product/1")
//                .exchange()
//                .expectStatus().isOk();
//    }
//}
