package com.tindi.productservice.controller;

import com.tindi.productservice.domain.ProductDomain;
import com.tindi.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("all")
    public Flux<ProductDomain> getAll(){
        System.out.println("Get all method called....");
        return this.productService.getAllProducts();
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<ProductDomain>> getProductById(@PathVariable String id){
        return this.productService.getProductById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ProductDomain> insertProduct(@RequestBody Mono<ProductDomain> productDomainMono){
        return this.productService.insertProduct(productDomainMono);
    }

    @PutMapping("{id}")
    public Mono<ResponseEntity<ProductDomain>> updateProduct(@PathVariable String id, @RequestBody Mono<ProductDomain> productDomainMono){
        System.out.println("Update method called...");
        return this.productService.updateProduct(id, productDomainMono)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteProduct(@PathVariable String id){
        return this.productService.deleteProduct(id);
    }
}
