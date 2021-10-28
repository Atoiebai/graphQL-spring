package com.example.graphqlspring.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.example.graphqlspring.controller.MainService;
import com.example.graphqlspring.domain.User;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserQuery implements GraphQLQueryResolver {

    private final MainService mainService;

    public UserQuery(MainService mainService) {
        this.mainService = mainService;
    }


    public User getUser(Integer id) {
        return (mainService.get(id));
    }

    public List<User> getUsers(Optional<Long> limit) {
        return limit.map(aLong -> mainService.getUsers().stream().limit(aLong).collect(Collectors.toList())).orElseGet(mainService::getUsers);
    }
}