package com.pennyplanner.splitz.resolver;

import com.pennyplanner.splitz.model.Group;
import com.pennyplanner.splitz.service.GroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class GroupController {
    @Autowired
    private GroupService groupService;

    @QueryMapping
    public Optional<Group> getGroupById(@Argument Long groupId) {
        return groupService.getGroupById(groupId);
    }

    @QueryMapping
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }
}
