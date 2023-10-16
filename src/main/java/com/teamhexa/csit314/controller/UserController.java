package com.teamhexa.csit314.controller;

import com.teamhexa.csit314.entity.User;
import com.teamhexa.csit314.service.UserService;
import com.teamhexa.csit314.EndPointsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;
    @GetMapping(EndPointsList.getAllUser)
    public List<User> findAllUsers(){
        return service.getUsers();
    }
    @GetMapping(EndPointsList.getUserById)
    public User findUserById(@PathVariable int id){
        return service.getUserById(id);
    }
    @PostMapping(EndPointsList.createUser)
    public User addUser(@RequestBody User user) {
        return service.saveUser(user);
    }
    @PutMapping(EndPointsList.getUserById)
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return service.updateUser(id, user);
    }
    @DeleteMapping(EndPointsList.getUserById)
    public String deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }
    @GetMapping("/")
    public String getPage(){
        return "Welcome";
    }
}
