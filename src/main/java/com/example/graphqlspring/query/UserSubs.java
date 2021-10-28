package com.example.graphqlspring.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.example.graphqlspring.controller.MainService;
import com.example.graphqlspring.domain.User;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
public class UserSubs implements GraphQLSubscriptionResolver {

    private final MainService mainService;

    public UserSubs(MainService mainService) {
        this.mainService = mainService;
    }


    public Publisher<User> getUser(Integer id) {
        return Flux.fromStream(mainService.getUsers().stream()).delayElements(Duration.ofSeconds(10));
    }
}
