package com.nttdata.bootcamp.project.product.infraestructure;

import com.nttdata.bootcamp.project.product.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends ReactiveMongoRepository<Product, Integer> {
}
