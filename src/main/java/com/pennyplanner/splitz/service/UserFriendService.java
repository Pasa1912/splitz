package com.pennyplanner.splitz.service;

import com.pennyplanner.splitz.model.User;
import com.pennyplanner.splitz.model.relations.UserFriend;
import com.pennyplanner.splitz.model.relations.UserFriendId;
import com.pennyplanner.splitz.repository.UserFriendRepository;
import com.pennyplanner.splitz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserFriendService {

    private final UserFriendRepository userFriendRepository;
    private final UserRepository userRepository;

    public UserFriendId getUserFriendId(Long userId, Long friendId) {
        if(userId > friendId) {
            return getUserFriendId(friendId, userId);
        }

        return userFriendRepository.getUserFriendId(userId, friendId).orElse(null);
    }

    public List<User> getFriendsByUserId(Long userId) {
        return userFriendRepository.findFriendsByUserId(userId);
    }

    public UserFriend addUserFriend(Long userId, Long friendId) {
        if(userId > friendId) {
            return addUserFriend(friendId, userId);
        }

        User user = userRepository.findById(userId).orElse(null);
        User friend = userRepository.findById(friendId).orElse(null);

        UserFriend userFriend = new UserFriend(user,friend);

        return userFriendRepository.save(userFriend);
    }

    public void removeUserFriend(Long userId, Long friendId) {
        UserFriendId userFriendId = getUserFriendId(userId, friendId);

        if(userFriendId == null) {
            throw new RuntimeException("UserFriend not found");
        }

        userFriendRepository.deleteById(userFriendId);
    }
}

