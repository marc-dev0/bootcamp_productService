package com.nttdata.bootcamp.project.product.service;

import com.nttdata.bootcamp.project.product.dto.ActiveAccountDto;
import com.nttdata.bootcamp.project.product.infraestructure.IActiveAccountRepository;
import com.nttdata.bootcamp.project.product.service.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ActiveAccountServiceImpl implements IActiveAccountService {
    @Autowired
    private IActiveAccountRepository repository;
    public Flux<ActiveAccountDto> getAll() {
        return repository.findAll().map(AppUtils::entityToDto);
    }

    @Override
    public Mono<ActiveAccountDto> getById(String id) {
        return repository.findById(id).map(AppUtils::entityToDto);
    }

    @Override
    public Mono<ActiveAccountDto> save(Mono<ActiveAccountDto> object) {
        return object.map(AppUtils::dtoToEntity)
                .flatMap(repository::insert)
                .map(AppUtils::entityToDto);
    }

    @Override
    public Mono<ActiveAccountDto> update(Mono<ActiveAccountDto> object, String id) {
        return repository.findById(id)
                .flatMap(
                        p -> object.map(AppUtils::dtoToEntity)
                                .doOnNext(e -> e.setId(id))
                )
                .flatMap(repository::save)
                .map(AppUtils::entityToDto);
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }
}
