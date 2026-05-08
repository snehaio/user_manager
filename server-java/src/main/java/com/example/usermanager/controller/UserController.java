package com.example.usermanager.controller;

import com.example.usermanager.model.User;
import com.example.usermanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @QueryMapping
    public List<User> getUsers(
        @Argument Integer limit,
        @Argument Integer offset,
        @Argument String name) {
        return userService.getUsers(limit, offset, name);
    }

    @QueryMapping
    public User getUserById(@Argument String id) {
        return userService.getUserById(id);
    }

    @MutationMapping
    public User createUser(
        @Argument String name,
        @Argument int age,
        @Argument boolean isMarried,
        @Argument String password) {
        return userService.createUser(name, age, isMarried, password);
    }

    @MutationMapping
    public User updateUser(@Argument String id, @Argument boolean isMarried) {
        return userService.updateUser(id, isMarried);
    }

    @MutationMapping
    public Boolean deleteUser(@Argument String id) {
        return userService.deleteUser(id);
    }
    @MutationMapping
public String login(@Argument String name, @Argument String password) {
    return userService.login(name, password);
}
}