package com.letsdoit.core.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.letsdoit.core.product.domain.PartnerProductCategory;
import com.letsdoit.core.product.repository.PartnerProductCategoryRepository;

@Service
public class PartnerProductCategoryService {
    @Autowired
    PartnerProductCategoryRepository partnerProductCategoryRepository;

    public Flux<PartnerProductCategory> getAllPartnerProductCategories() {
        return this.partnerProductCategoryRepository.findAll();
    }

    //Get  PartnerProductCategory by id
    public Mono<PartnerProductCategory> getPartnerProductCategoryById(String id) {
        return this.partnerProductCategoryRepository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("PartnerProductCategory not found")));
    }

    //Insert PartnerProductCategory
    public Mono<PartnerProductCategory> insertPartnerProductCategory(Mono<PartnerProductCategory> partnerProductCategoryMono) {
        return partnerProductCategoryMono
                .flatMap(partnerProductCategory -> this.partnerProductCategoryRepository.insert(partnerProductCategory));
    }

    //Update PartnerProductCategory
    public Mono<PartnerProductCategory> updatePartnerProductCategory(String id, Mono<PartnerProductCategory> partnerProductCategoryMono){
        return this.partnerProductCategoryRepository.findById(id)
                .flatMap(partnerProductCategory -> partnerProductCategoryMono
                            .doOnNext(partnerProductCategory1 -> partnerProductCategory1.setId(id))
                        .flatMap(this.partnerProductCategoryRepository::save));
    }

    //Delete PartnerProductCategory
    public Mono<Void> deletePartnerProductCategory(String id){
        return this.partnerProductCategoryRepository.deleteById(id);
    }
}
