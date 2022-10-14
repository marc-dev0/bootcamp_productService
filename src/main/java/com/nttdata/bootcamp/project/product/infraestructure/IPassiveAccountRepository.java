package com.nttdata.bootcamp.project.product.infraestructure;

import com.nttdata.bootcamp.project.product.entity.PassiveAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPassiveAccountRepository extends ReactiveMongoRepository<PassiveAccount, String> {
}