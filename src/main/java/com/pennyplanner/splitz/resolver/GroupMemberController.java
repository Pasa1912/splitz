package com.pennyplanner.splitz.resolver;

import com.pennyplanner.splitz.model.Group;
import com.pennyplanner.splitz.model.User;
import com.pennyplanner.splitz.service.GroupMemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GroupMemberController {
    @Autowired
    private GroupMemberService groupMemberService;

    @QueryMapping
    public List<Group> getGroupsByUserId(@Argument Long userId) {
        return groupMemberService.findGroupsByUserId(userId);
    }

    @QueryMapping
    public List<User> getMembersByGroupId(@Argument Long groupId) {
        return groupMemberService.findUsersByGroupId(groupId);
    }

    @MutationMapping
    public void addGroupMember(@Argument Long userId, @Argument Long groupId, @Argument String role) {
        groupMemberService.createGroupMember(userId, groupId, role);
    }

    @MutationMapping
    public void deleteGroupMember(@Argument Long groupId, @Argument Long userId) {
        groupMemberService.deleteGroupMember(groupId, userId);
    }
}
