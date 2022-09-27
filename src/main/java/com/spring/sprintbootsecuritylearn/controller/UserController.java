package com.spring.sprintbootsecuritylearn.controller;


import com.spring.sprintbootsecuritylearn.models.User;
import com.spring.sprintbootsecuritylearn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;




    // all users
    @GetMapping("/")
    public List<User> getAllUser(){
        return this.userService.getAllUser();
    }

    // get single user

//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{username}")
    public User getSingleUser(@PathVariable("username") String username){
        return this.userService.getSingleUser(username);
    }


    // add user
    @PostMapping("/")
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }
}
