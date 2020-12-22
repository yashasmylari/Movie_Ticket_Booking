package com.ticket.movie.controller;

import com.ticket.movie.model.User;
import com.ticket.movie.service.UserOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/useroperations")
public class UserController {

    @Autowired
    private UserOperationService userOperations;

    @PostMapping(value = "/registeruser")
    @ResponseStatus(HttpStatus.CREATED)
    public User registration(@RequestBody User user){
        return userOperations.userRegistration(user);
    }

    @GetMapping(value = "/getregistereduser")
    public List<User> getRegisteredUser(){
        return userOperations.getRegisteredUser();
    }

    @PutMapping(value = "/updateuser")
    public User updateUser(@RequestBody User user){
        return userOperations.updateUser(user);
    }

    @DeleteMapping(value = "/deleteuser")
    public String deleteUser(@RequestBody User user){
        userOperations.deleteUser(user);
        return "User Deleted";
    }

}
