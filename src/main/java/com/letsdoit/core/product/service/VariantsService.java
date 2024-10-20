package com.letsdoit.core.product.service;

import com.letsdoit.core.product.domain.Variants;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import com.letsdoit.core.product.repository.VariantsRepository;
import reactor.core.publisher.Mono;

@Service
public class VariantsService {
    @Autowired
    VariantsRepository variantsRepository;

    public Flux<Variants> getAllVariants() {
        return this.variantsRepository.findAll();
    }

    public Mono<Variants> getVariantsById(String id) {
        return this.variantsRepository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("Variants not found")));
    }

    public Mono<Variants> insertVariants(Mono<Variants> variantsMono) {
        return variantsMono
                .flatMap(variants -> this.variantsRepository.insert(variants));
    }

    public Mono<Variants> updateVariants(String id, Mono<Variants> variantsMono){
        return this.variantsRepository.findById(id)
                .flatMap(variants -> variantsMono
                            .doOnNext(variants1 -> variants1.setId(id))
                        .flatMap(this.variantsRepository::save));
    }

    public Mono<Void> deleteVariants(String id){
        return this.variantsRepository.deleteById(id);
    }
}
