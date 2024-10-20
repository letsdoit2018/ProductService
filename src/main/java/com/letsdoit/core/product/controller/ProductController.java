package com.letsdoit.core.product.controller;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.letsdoit.core.product.service.ProductService;
import com.letsdoit.core.product.domain.Product;


@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;

    //get all products
    @GetMapping("all")
    public Flux<Product> getAll(){
        return this.productService.getAllProducts();
    }

    //getProductById
    @GetMapping("{id}")
    public Mono<ResponseEntity<Product>> getProductById(@PathVariable String id){
        return this.productService.getProductById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    //insertProduct
    @PostMapping
    public Mono<Product> insertProduct(@RequestBody Mono<Product> productMono){
        return this.productService.insertProduct(productMono);
    }

    //updateProduct
    @PutMapping("{id}")
    public Mono<ResponseEntity<Product>> updateProduct(@PathVariable String id, @RequestBody Mono<Product> productMono){
        return this.productService.updateProduct(id, productMono)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    //deleteProduct
    @DeleteMapping("{id}")
    public Mono<Void> deleteProduct(@PathVariable String id){
        return this.productService.deleteProduct(id);
    }
}
