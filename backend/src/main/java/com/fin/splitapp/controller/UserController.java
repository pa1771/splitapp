package com.fin.splitapp.controller;

import com.fin.splitapp.dto.UserDto;
import com.fin.splitapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
        userService.registerUser(userDto);
        return ResponseEntity.ok().body("User Created");
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public ResponseEntity<String> loginUser(@RequestBody UserDto userDto) {
        String token = userService.loginUser(userDto);
        return ResponseEntity.ok().body(token);
    }
}
