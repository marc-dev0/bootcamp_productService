package com.nttdata.bootcamp.project.product.controller;

import com.nttdata.bootcamp.project.product.dto.PassiveAccountDto;
import com.nttdata.bootcamp.project.product.service.IPassiveAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/passiveAccounts")
public class PassiveAccountController {
    @Autowired
    IPassiveAccountService service;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<PassiveAccountDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Mono<PassiveAccountDto> getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<PassiveAccountDto> save(@RequestBody PassiveAccountDto passiveAccountDto){
        return service.save(Mono.just(passiveAccountDto));
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<PassiveAccountDto> update(@RequestBody PassiveAccountDto passiveAccountDto, @PathVariable String id) {
        return service.update(Mono.just(passiveAccountDto), id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }
}
