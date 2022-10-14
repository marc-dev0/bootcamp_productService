package com.nttdata.bootcamp.project.product.controller;

import com.nttdata.bootcamp.project.product.dto.ActiveAccountDto;
import com.nttdata.bootcamp.project.product.dto.ProductDto;
import com.nttdata.bootcamp.project.product.service.IActiveAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/activeAccounts")
public class ActiveAccountController {
    @Autowired
    IActiveAccountService service;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ActiveAccountDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Mono<ActiveAccountDto> getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ActiveAccountDto> save(@RequestBody ActiveAccountDto activeAccountDto){
        return service.save(Mono.just(activeAccountDto));
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<ActiveAccountDto> update(@RequestBody ActiveAccountDto activeAccountDto, @PathVariable String id) {
        return service.update(Mono.just(activeAccountDto), id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }
}
