package com.dkt.study.mytube.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class HelloController {

    //@ResponseBody
    @GetMapping("hello")
    public Mono<String> hello(){
        return Mono.just("hello1111");
    }
}
