package com.nttdata.bootcamp.project.product.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
public interface IGeneralService<T> {
    Flux<T> getAll();
    Mono<T> getById(String id);
    Mono<T> save(Mono<T> object);
    Mono<T> update(Mono<T> object, String id);
    Mono<Void> delete(String id);
}
