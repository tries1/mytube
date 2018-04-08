package com.dkt.study.mytube.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by glenn on 2018. 4. 8..
 */
@RestController
public class FluxTestController {

    List<Event> events = Arrays.asList(new Event(1L, "value1"), new Event(2L, "value2"));

    @GetMapping("event")
    public Mono<List<Event>> event() {
        return Mono.just(events);
    }

    @GetMapping(value = "events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Event> events() {
        Flux<String> genetate = Flux.generate(sink -> sink.next("value"));
        Flux<Long> inteval = Flux.interval(Duration.ofSeconds(1));
        //return Flux.fromIterable(events).delayElements(Duration.ofSeconds(3));
        /*return Flux
            .<Event>generate(sink -> sink.next(new Event(System.currentTimeMillis(), "value")))
            .delayElements(Duration.ofSeconds(1))
            .take(10);*/
        //map return tuple
        return Flux.zip(genetate, inteval)
                .map(tu -> new Event(tu.getT2(), tu.getT1()))
                .take(10);
    }


    @Data
    public class Event {
        Long id;
        String value;

        public Event(Long id, String value){
            this.id = id;
            this.value = value;
        }
    }
}
