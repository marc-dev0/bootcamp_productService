package com.nttdata.bootcamp.project.product.service;

import com.nttdata.bootcamp.project.product.dto.ProductDto;
import com.nttdata.bootcamp.project.product.infraestructure.IProductRepository;
import com.nttdata.bootcamp.project.product.service.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public Mono<ProductDto> saveProduct(Mono<ProductDto> productDtoMono) {
        return productDtoMono.map(AppUtils::dtoToEntity)
                .flatMap(productRepository::insert)
                .map((AppUtils::entityToDto));
    }

    @Override
    public Flux<ProductDto> getProducts() {
        return null;
    }

    @Override
    public Mono<ProductDto> getProduct(String id) {
        return null;
    }

    @Override
    public Mono<ProductDto> updateProduct(Mono<ProductDto> productDtoMono, String id) {
        return null;
    }

    @Override
    public Mono<Void> deleteProduct(String id) {
        return null;
    }
}
