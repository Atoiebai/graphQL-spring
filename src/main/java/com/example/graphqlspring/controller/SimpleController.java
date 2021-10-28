package com.example.graphqlspring.controller;

import com.example.graphqlspring.domain.User;
import com.example.graphqlspring.query.UserSubs;
import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SimpleController {

    private final UserSubs subs;
    private final MainService service;

    public SimpleController(UserSubs subs, MainService service) {
        this.subs = subs;
        this.service = service;
    }


    @GetMapping(produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<User> getUsers() {
     return Flux.fromIterable(service.getUsers())
             .delayElements(Duration.ofSeconds(2));
    }
}
