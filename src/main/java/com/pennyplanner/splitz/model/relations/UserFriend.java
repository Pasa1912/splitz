package com.pennyplanner.splitz.model.relations;

import com.pennyplanner.splitz.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user_friends")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class UserFriend {

    @EmbeddedId
    private UserFriendId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("friendId")
    @JoinColumn(name = "friend_id")
    private User friend;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public UserFriend(User user, User friend) {
        this.user = user;
        this.friend = friend;
        this.createdAt = LocalDateTime.now();
    }
}
