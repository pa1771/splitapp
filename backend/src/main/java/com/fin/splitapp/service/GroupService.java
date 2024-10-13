package com.fin.splitapp.service;

import com.fin.splitapp.dto.GroupDto;
import com.fin.splitapp.model.Group;
import com.fin.splitapp.model.User;
import com.fin.splitapp.repo.GroupRepository;
import com.fin.splitapp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    UserRepository userRepository;

    public void createGroup(GroupDto groupDto) {
        Group group = new Group();
        group.setName(groupDto.getName());
        group.setDescription(groupDto.getDescription());
        List<User> users = new ArrayList<>();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUserName(userDetails.getUsername());
        if (user != null) {
            users.add(user);
        } else {
            throw new RuntimeException("User not found");
        }

        group.setUsers(users);
        groupRepository.save(group);
    }
}
