package com.nttdata.bootcamp.project.product.infraestructure;

import com.nttdata.bootcamp.project.product.entity.ActiveAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActiveAccountRepository extends ReactiveMongoRepository<ActiveAccount, String> {
}
