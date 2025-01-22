package com.pennyplanner.splitz.service;

import com.pennyplanner.splitz.model.Group;
import com.pennyplanner.splitz.model.User;
import com.pennyplanner.splitz.model.relations.GroupMember;
import com.pennyplanner.splitz.model.relations.GroupMemberId;
import com.pennyplanner.splitz.repository.GroupMemberRepository;
import com.pennyplanner.splitz.repository.GroupRepository;
import com.pennyplanner.splitz.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class GroupMemberService {
    private final GroupMemberRepository groupMemberRepository;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    public GroupMemberService(GroupMemberRepository groupMemberRepository, UserRepository userRepository, GroupRepository groupRepository) {
        this.groupMemberRepository = groupMemberRepository;
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }

    public GroupMemberId getGroupMemberId(Long userId, Long groupId) {
        return groupMemberRepository.getGroupMemberId(userId, groupId).orElse(null);
    }

    public GroupMember createGroupMember(Long userId, Long groupId, String role) {
        GroupMember groupMember = new GroupMember();

        User user = userRepository.findById(userId).orElse(null);
        Group group = groupRepository.findById(groupId).orElse(null);

        groupMember.setUser(user);
        groupMember.setGroup(group);
        groupMember.setRole(role);

        return groupMemberRepository.save(groupMember);
    }

    public Optional<GroupMember> getGroupMemberById(GroupMemberId id) {
        return groupMemberRepository.findById(id);
    }

    public List<GroupMember> getAllGroupMembers() {
        return groupMemberRepository.findAll();
    }

    public GroupMember updateGroupMember(Long userId, Long groupId, String role) {
        GroupMemberId groupMemberId = getGroupMemberId(userId, groupId);

        if (groupMemberId == null) {
            throw new RuntimeException("GroupMember not found");
        }

        GroupMember groupMember = groupMemberRepository.findById(groupMemberId)
                .orElseThrow(() -> new RuntimeException("GroupMember not found"));

        groupMember.setRole(role);

        return groupMemberRepository.save(groupMember);
    }

    public void deleteGroupMember(Long userId, Long groupId) {
        GroupMemberId groupMemberId = getGroupMemberId(userId, groupId);

        if (groupMemberId == null) {
            throw new RuntimeException("GroupMember not found");
        }

        groupMemberRepository.deleteById(groupMemberId);
    }

    public List<Group> findGroupsByUserId(Long userId) {
        return groupMemberRepository.findGroupsByUserId(userId);
    }

    public List<User> findUsersByGroupId(Long groupId) {
        return groupMemberRepository.findUsersByGroupId(groupId);
    }
}

