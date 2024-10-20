//package com.letsdoit.core.product.service;
//
//import com.letsdoit.core.product.domain.Product;
//import com.letsdoit.core.product.repository.ProductRepository;
//import com.letsdoit.core.product.service.ProductService;
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
//public class ProductServiceTest {
//
//    @Mock
//    private ProductRepository productRepository;
//
//    @InjectMocks
//    private ProductService productService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testGetAllProducts() {
//        Product product = new Product("1", "Product1", 100.0);
//        when(productRepository.findAll()).thenReturn(Flux.just(product));
//
//        Flux<Product> productFlux = productService.getAllProducts();
//
//        StepVerifier.create(productFlux)
//                .expectNext(product)
//                .verifyComplete();
//    }
//
//    @Test
//    void testGetProductById() {
//        Product product = new Product("1", "Product1", 100.0);
//        when(productRepository.findById("1")).thenReturn(Mono.just(product));
//
//        Mono<Product> productMono = productService.getProductById("1");
//
//        StepVerifier.create(productMono)
//                .expectNext(product)
//                .verifyComplete();
//    }
//
//    @Test
//    void testGetProductByIdNotFound() {
//        when(productRepository.findById("1")).thenReturn(Mono.empty());
//
//        Mono<Product> productMono = productService.getProductById("1");
//
//        StepVerifier.create(productMono)
//                .expectErrorMessage("Product not found")
//                .verify();
//    }
//
//    @Test
//    void testInsertProduct() {
//        Product product = new Product("1", "Product1", 100.0);
//        when(productRepository.insert(any(Product.class))).thenReturn(Mono.just(product));
//
//        Mono<Product> productMono = productService.insertProduct(Mono.just(product));
//
//        StepVerifier.create(productMono)
//                .expectNext(product)
//                .verifyComplete();
//    }
//
//    @Test
//    void testUpdateProduct() {
//        Product existingProduct = new Product("1", "Product1", 100.0);
//        Product updatedProduct = new Product("1", "UpdatedProduct", 150.0);
//        when(productRepository.findById("1")).thenReturn(Mono.just(existingProduct));
//        when(productRepository.save(any(Product.class))).thenReturn(Mono.just(updatedProduct));
//
//        Mono<Product> productMono = productService.updateProduct("1", Mono.just(updatedProduct));
//
//        StepVerifier.create(productMono)
//                .expectNext(updatedProduct)
//                .verifyComplete();
//    }
//
//    @Test
//    void testDeleteProduct() {
//        when(productRepository.deleteById("1")).thenReturn(Mono.empty());
//
//        Mono<Void> voidMono = productService.deleteProduct("1");
//
//        StepVerifier.create(voidMono)
//                .verifyComplete();
//    }
//}
