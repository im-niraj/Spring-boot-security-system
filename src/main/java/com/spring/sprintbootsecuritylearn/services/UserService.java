package com.spring.sprintbootsecuritylearn.services;

import com.spring.sprintbootsecuritylearn.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> list = new ArrayList<>();

    public UserService() {
        list.add(new User("abc", "abc", "abc@gmail.com"));
        list.add(new User("xyz", "xyz", "xyz@gmail.com"));
    }

//get all users
    public List<User> getAllUser(){
        return this.list;
    }

//  get single user
    public User getSingleUser(String username){
        return  this.list.stream().filter((user) -> user.getUsername().equals(username)).findAny().orElse(null);
    }

//    add new user
    public User addUser(User user){
        this.list.add(user);
        return  user;
    }
}
