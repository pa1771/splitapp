package com.fin.splitapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class GroupDto {
    private int groupId;
    private String name;
    private String description;
    List<UserDto> users;

    public GroupDto() {
        users = new ArrayList<>();
    }
}
