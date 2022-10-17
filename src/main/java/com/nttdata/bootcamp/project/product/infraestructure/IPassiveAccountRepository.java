package com.nttdata.bootcamp.project.product.infraestructure;

import com.nttdata.bootcamp.project.product.entity.PassiveAccount;
import com.nttdata.bootcamp.project.product.entity.request.PAccountCreationRequest;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface IPassiveAccountRepository extends ReactiveMongoRepository<PassiveAccount, String> {
}