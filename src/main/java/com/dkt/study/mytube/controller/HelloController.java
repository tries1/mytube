package com.dkt.study.mytube.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class HelloController {

    //@ResponseBody
    @GetMapping("hello")
    public Mono<String> hello(){

        log.debug("test : {}", 123);

        return Mono.just("hello1111");
    }
}
