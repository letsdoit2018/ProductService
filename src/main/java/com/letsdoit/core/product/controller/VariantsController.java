package com.letsdoit.core.product.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import com.letsdoit.core.product.service.VariantsService;
import com.letsdoit.core.product.domain.Variants;


@RestController
@RequestMapping("variants")
public class VariantsController {
    @Autowired
    VariantsService variantsService;

    //get all variants
    @GetMapping("all")
    public Flux<Variants> getAll(){
        return this.variantsService.getAllVariants();
    }

    //getVariantsById
    @GetMapping("{id}")
    public Mono<ResponseEntity<Variants>> getVariantsById(@PathVariable String id){
        return this.variantsService.getVariantsById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    //insertVariants
    @PostMapping
    public Mono<Variants> insertVariants(@RequestBody Mono<Variants> variantsMono){
        return this.variantsService.insertVariants(variantsMono);
    }

    //updateVariants
    @PutMapping("{id}")
    public Mono<ResponseEntity<Variants>> updateVariants(@PathVariable String id, @RequestBody Mono<Variants> variantsMono){
        return this.variantsService.updateVariants(id, variantsMono)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    //deleteVariants
    @DeleteMapping("{id}")
    public Mono<Void> deleteVariants(@PathVariable String id){
        return this.variantsService.deleteVariants(id);
    }
}
