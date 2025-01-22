package com.pennyplanner.splitz.repository;

import com.pennyplanner.splitz.model.Group;
import com.pennyplanner.splitz.model.User;
import com.pennyplanner.splitz.model.relations.GroupMember;
import com.pennyplanner.splitz.model.relations.GroupMemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupMemberRepository extends JpaRepository<GroupMember, GroupMemberId> {
    @Query("SELECT groupMember.id from GroupMember groupMember WHERE groupMember.user.id = :userId and groupMember.group.id = :groupId")
    Optional<GroupMemberId> getGroupMemberId(@Param("userId") Long userId, @Param("groupId") Long groupId);

    @Query("SELECT groupMember.group FROM GroupMember groupMember WHERE groupMember.user.id = :userId")
    List<Group> findGroupsByUserId(@Param("userId") Long userId);

    @Query("SELECT groupMember.user FROM GroupMember groupMember WHERE groupMember.group.id = :groupId")
    List<User> findUsersByGroupId(@Param("groupId") Long groupId);
}
