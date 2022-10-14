package com.nttdata.bootcamp.project.product.service;

import com.nttdata.bootcamp.project.product.dto.PassiveAccountDto;
import com.nttdata.bootcamp.project.product.infraestructure.IPassiveAccountRepository;
import com.nttdata.bootcamp.project.product.service.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PassiveAcountServiceImpl implements  IPassiveAccountService {
    @Autowired
    private IPassiveAccountRepository repository;

    @Override
    public Flux<PassiveAccountDto> getAll() {
        return repository.findAll().map(AppUtils::entityToDto);
    }

    @Override
    public Mono<PassiveAccountDto> getById(String id) {
        return repository.findById(id).map(AppUtils::entityToDto);
    }

    @Override
    public Mono<PassiveAccountDto> save(Mono<PassiveAccountDto> object) {
        return object.map(AppUtils::dtoToEntity)
                .flatMap(repository::insert)
                .map(AppUtils::entityToDto);
    }

    @Override
    public Mono<PassiveAccountDto> update(Mono<PassiveAccountDto> object, String id) {
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
