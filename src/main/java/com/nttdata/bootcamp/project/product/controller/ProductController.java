package com.nttdata.bootcamp.project.product.controller;

import com.nttdata.bootcamp.project.product.dto.ProductDto;
import com.nttdata.bootcamp.project.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    IProductService productService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ProductDto> saveProduct(@RequestBody ProductDto productDto){
        return productService.saveProduct(Mono.just(productDto));
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Mono<ProductDto> getProduct(@PathVariable String id) {
        return productService.getProduct(id);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<ProductDto> getProducts() {
        return productService.getProducts();
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<ProductDto> updateProduct(@RequestBody ProductDto productDto, @PathVariable String id) {
        return productService.updateProduct(Mono.just(productDto), id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<Void> deleteProduct(@PathVariable String id) {
        return productService.deleteProduct(id);
    }
}
