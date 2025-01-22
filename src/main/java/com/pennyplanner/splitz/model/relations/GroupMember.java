package com.pennyplanner.splitz.model.relations;

import com.pennyplanner.splitz.model.Group;
import com.pennyplanner.splitz.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "group_member")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class GroupMember {

    @EmbeddedId
    private GroupMemberId id;

    @ManyToOne
    @MapsId("groupId")
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @MapsId("memberId")
    @JoinColumn(name = "member_id")
    private User user;

    private String role;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
