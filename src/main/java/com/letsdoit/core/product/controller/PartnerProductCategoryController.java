package com.letsdoit.core.product.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.letsdoit.core.product.service.PartnerProductCategoryService;
import com.letsdoit.core.product.domain.PartnerProductCategory;

@RestController
@RequestMapping("productcategory")
public class PartnerProductCategoryController {
    @Autowired
    PartnerProductCategoryService partnerProductCategoryService;

    //get all partner product categories
    @GetMapping("all")
    public Flux<PartnerProductCategory> getAll(){
        return this.partnerProductCategoryService.getAllPartnerProductCategories();
    }

    //getPartnerProductCategoryById
    @GetMapping("{id}")
    public Mono<PartnerProductCategory> getPartnerProductCategoryById(@PathVariable String id){
        return this.partnerProductCategoryService.getPartnerProductCategoryById(id);
    }

    //insertPartnerProductCategory
    @PostMapping
    public Mono<PartnerProductCategory> insertPartnerProductCategory(@RequestBody Mono<PartnerProductCategory> partnerProductCategoryMono){
        return this.partnerProductCategoryService.insertPartnerProductCategory(partnerProductCategoryMono);
    }

    //updatePartnerProductCategory
    @PutMapping("{id}")
    public Mono<PartnerProductCategory> updatePartnerProductCategory(@PathVariable String id, @RequestBody Mono<PartnerProductCategory> partnerProductCategoryMono){
        return this.partnerProductCategoryService.updatePartnerProductCategory(id, partnerProductCategoryMono);
    }

    //deletePartnerProductCategory
    @DeleteMapping("{id}")
    public Mono<Void> deletePartnerProductCategory(@PathVariable String id){
        return this.partnerProductCategoryService.deletePartnerProductCategory(id);
    }
}
