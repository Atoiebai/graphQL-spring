package com.example.graphqlspring.controller;


import com.example.graphqlspring.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MainService {
    private static final Map<Integer , User> users = new HashMap<>();
    private static int id = 6;

    static {
        users.put(0 , new User("Islam" , 12));
        users.put(1 , new User("Ilkhom" , 122));
        users.put(2 , new User("Ilkhom12345" , 122));
        users.put(3 , new User("Islam12345" , 122));
        users.put(4 , new User("Oybek" , 122));
        users.put(5 , new User("Misha" , 122));
    }

    public User add(User user) {
        users.put(id , user);

       return  users.get(id++);
    }

    public User get(Integer id) {
        return users.get(id);
    }


    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

}
