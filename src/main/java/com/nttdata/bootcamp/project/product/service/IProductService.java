package com.nttdata.bootcamp.project.product.service;

import com.nttdata.bootcamp.project.product.dto.ProductDto;
import com.nttdata.bootcamp.project.product.entity.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface IProductService {
    Mono<ProductDto> saveProduct(Mono<ProductDto> productDtoMono);
    Flux<ProductDto> getProducts();
    Mono<ProductDto> getProduct(String id);
    Mono<ProductDto> updateProduct(Mono<ProductDto> productDtoMono, String id);
    Mono<Void> deleteProduct(String id);
}
