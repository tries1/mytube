package com.dkt.study.mytube.controller;

import com.dkt.study.mytube.model.Message;
import com.dkt.study.mytube.service.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HelloController {
    private final MessageService messageService;

    //@ResponseBody
    @GetMapping("hello")
    public Mono<String> hello(){
        return Mono.just("hello1111");
    }

    @GetMapping("message/{id}")
    public Mono<Message> message(@PathVariable Long id){
        return Mono.just(messageService.getMessage(id));
    }
}
