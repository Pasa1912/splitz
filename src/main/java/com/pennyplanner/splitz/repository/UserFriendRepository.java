package com.pennyplanner.splitz.repository;

import com.pennyplanner.splitz.model.User;
import com.pennyplanner.splitz.model.relations.UserFriend;
import com.pennyplanner.splitz.model.relations.UserFriendId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserFriendRepository extends JpaRepository<UserFriend, UserFriendId> {
    @Query("SELECT uf.id FROM UserFriend uf WHERE uf.user.id = :userId AND uf.friend.id = :friendId")
    Optional<UserFriendId> getUserFriendId(@Param("userId") Long userId, @Param("friendId") Long friendId);

    @Query("SELECT uf.friend FROM UserFriend uf WHERE uf.user.id = :userId OR uf.friend.id = :userId")
    List<User> findFriendsByUserId(@Param("userId") Long userId);
}

