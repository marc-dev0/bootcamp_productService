package com.nttdata.bootcamp.project.product.service;

import com.nttdata.bootcamp.project.product.dto.PassiveAccountDto;
import com.nttdata.bootcamp.project.product.entity.PassiveAccount;
import com.nttdata.bootcamp.project.product.entity.Product;
import com.nttdata.bootcamp.project.product.entity.request.PAccountCreationRequest;
import com.nttdata.bootcamp.project.product.infraestructure.IPassiveAccountRepository;
import com.nttdata.bootcamp.project.product.infraestructure.IProductRepository;
import com.nttdata.bootcamp.project.product.service.utils.AppUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class PassiveAcountServiceImpl implements  IPassiveAccountService {
    @Autowired
    private IPassiveAccountRepository repository;
    IProductRepository productRepository;
    @Override
    public Flux<PassiveAccountDto> getAll() {
        return repository.findAll().map(AppUtils::entityToDto);
    }

    @Override
    public Mono<PassiveAccountDto> getById(String id) {
        return repository.findById(id).map(AppUtils::entityToDto);
    }

    @Override
    public Mono<PassiveAccount> save(Mono<PAccountCreationRequest> object) {
        Optional<Product> product = productRepository.findbyId(request.map(p->p.getProductoId()).toString());
        PassiveAccount create = new PassiveAccount();
        BeanUtils.copyProperties(object, create);
        create.setProduct(product.get());
        return object.flatMap(repository::insert());
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
