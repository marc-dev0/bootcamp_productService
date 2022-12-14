package com.nttdata.bootcamp.project.product.service;

import com.nttdata.bootcamp.project.product.dto.ActiveAccountDto;
import com.nttdata.bootcamp.project.product.dto.PassiveAccountDto;
import com.nttdata.bootcamp.project.product.entity.PassiveAccount;
import com.nttdata.bootcamp.project.product.entity.request.PAccountCreationRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface IPassiveAccountService {
    Flux<PassiveAccountDto> getAll();
    Mono<PassiveAccountDto> getById(String id);
    Mono<PassiveAccount> save(Mono<PAccountCreationRequest> object);
    Mono<PassiveAccountDto> update(Mono<PassiveAccountDto> object, String id);
    Mono<Void> delete(String id);
}
