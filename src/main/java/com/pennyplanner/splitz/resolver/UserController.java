package com.pennyplanner.splitz.resolver;

import com.pennyplanner.splitz.model.User;
import com.pennyplanner.splitz.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserService UserService;

    @QueryMapping
    public Optional<User> getUserById(@Argument Long UserId) {
        return UserService.getUserById(UserId);
    }

    @QueryMapping
    public List<User> getAllUsers() {
        return UserService.getAllUsers();
    }
}

