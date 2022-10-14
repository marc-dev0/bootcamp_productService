package com.nttdata.bootcamp.project.product.service;

import com.nttdata.bootcamp.project.product.dto.ActiveAccountDto;
import com.nttdata.bootcamp.project.product.dto.ProductDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface IActiveAccountService {
    Flux<ActiveAccountDto> getAll();
    Mono<ActiveAccountDto> getById(String id);
    Mono<ActiveAccountDto> save(Mono<ActiveAccountDto> activeAccountDtoMono);
    Mono<ActiveAccountDto> update(Mono<ActiveAccountDto> activeAccountDtoMono, String id);
    Mono<Void> delete(String id);
}
