package com.fin.splitapp.controller;

import com.fin.splitapp.dto.GroupDto;
import com.fin.splitapp.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GroupController {

    @Autowired
    GroupService groupService;

    @RequestMapping(value = "/group/create", method = RequestMethod.POST)
    public ResponseEntity<String> createGroup(@RequestBody GroupDto groupDto) {
        groupService.createGroup(groupDto);
        return ResponseEntity.ok("Group Created");
    }
}
