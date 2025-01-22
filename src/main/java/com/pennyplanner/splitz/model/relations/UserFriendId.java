package com.pennyplanner.splitz.model.relations;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class UserFriendId implements Serializable {

    private Long userId;
    private Long friendId;
}
