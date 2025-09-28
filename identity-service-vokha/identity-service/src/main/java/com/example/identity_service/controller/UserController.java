package com.example.identity_service.controller;

import com.example.identity_service.dto.request.UserCreatetionRequest;
import com.example.identity_service.dto.request.UserUpdateRequest;
import com.example.identity_service.entity.User;
import com.example.identity_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    User createUser(@RequestBody UserCreatetionRequest request) {
        userService.createUser(request);
        return userService.createUser(request);
    }

    @GetMapping
    List<User> getUsers(){
        return  userService.getUsers() ;
    }

    @GetMapping("/{userID}")
    User getUser(@PathVariable ("userID") Long userID){
        return userService.getUser(userID);
    }

    @PutMapping("/{userID}")
    User updateUser(@PathVariable Long userID, @RequestBody UserUpdateRequest request){
        return userService.updateUser(userID,request);
    }

    @DeleteMapping("/{userID}")
    String deleteUser(@PathVariable Long userID){
        userService.deleteUser(userID);
        return "user has been deleted";
    }
}
