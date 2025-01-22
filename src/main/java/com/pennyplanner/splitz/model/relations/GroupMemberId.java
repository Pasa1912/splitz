package com.pennyplanner.splitz.model.relations;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class GroupMemberId implements Serializable {
    private String groupId;
    private String memberId;
}
