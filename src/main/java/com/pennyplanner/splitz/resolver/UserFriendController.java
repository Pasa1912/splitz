package com.pennyplanner.splitz.resolver;

import com.pennyplanner.splitz.model.User;
import com.pennyplanner.splitz.model.relations.UserFriend;
import com.pennyplanner.splitz.service.UserFriendService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserFriendController {
    @Autowired
    private UserFriendService userFriendService;

    @QueryMapping
    public List<User> getFriendsByUserId(@Argument Long userId) {
        return userFriendService.getFriendsByUserId(userId);
    }

    @MutationMapping
    public UserFriend addUserFriend(@Argument Long userId, @Argument Long friendId) {
        return userFriendService.addUserFriend(userId, friendId);
    }

    @MutationMapping
    public void removeUserFriend(@Argument Long userId, @Argument Long friendId) {
        userFriendService.removeUserFriend(userId, friendId);
    }
}

