package com.example.graphqlspring.query;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphqlspring.controller.MainService;
import com.example.graphqlspring.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMutation implements GraphQLMutationResolver {
    private final MainService mainService;

    public UserMutation(MainService mainService) {
        this.mainService = mainService;
    }

    public User createUser(String username, Integer age) {

        return mainService.add(new User(username, age));
    }


}
