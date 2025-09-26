package com.Giahuy061105.identity_service.Controller;

import com.Giahuy061105.identity_service.Entity.User;
import com.Giahuy061105.identity_service.Service.UserService;
import com.Giahuy061105.identity_service.dto.request.UserCreationRequest;
import com.Giahuy061105.identity_service.dto.request.UserUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    User createUser(@RequestBody UserCreationRequest request){
        return userService.createUser(request);
    }

    @GetMapping
    List<User> getUsers(){
        return userService.getUsers();
    }
    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String userId){
        return userService.getUser(userId);
    }
    @PutMapping("/{userId}")
    User updateUser(@PathVariable("userId") String userId ,@RequestBody UserUpdateRequest request){
        return userService.UpdateUser(userId , request);
    }

    @DeleteMapping("/{userId}")
    String DeleteUser(@PathVariable String userId){
        userService.DeleteUser(userId);
        return "User has been delete!";
    }


}
