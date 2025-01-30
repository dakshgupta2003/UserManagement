package com.user.management.controllers;

import com.user.management.ApiResponse;
import com.user.management.entities.UserEntity;
import com.user.management.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// controller will ask services for business logic

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    // we can't create object of an interface, but in Springboot making the object of an interface uses the concept of dependency injection
    // when we use Autowired, we are telling spring to create the object of impl class of this service interface

    // get all users
    @GetMapping("/users")
    public ApiResponse<List<UserEntity>> getAllUsers() {
        return this.userService.getAllUsers();
    }

    // get single user details
    @GetMapping("/users/{userId}")
    public ApiResponse<UserEntity> getSingleUser(@PathVariable String userId) {
        return this.userService.getSingleUser(userId);
    }

    // by default the data us consumed in json format
    // if we want to explicitly write it then,
//    @PostMapping(path = "/users", consumes = "application/json", produces = "application/json")
    @PostMapping("/users")
    public ApiResponse<UserEntity> addUser(@RequestBody UserEntity userEntity){
        return this.userService.addUser(userEntity);
    }

    //update all user details
    @PutMapping("/users")
    public ApiResponse<UserEntity> updateUser(@RequestBody UserEntity userEntity){
        return this.userService.updateUser(userEntity);
    }

    // delete a user
    @DeleteMapping("/users/{userId}")
    public ApiResponse<UserEntity> deleteSingleUser(@PathVariable String userId){
        return this.userService.deleteSingleUser(userId);
    }

}
