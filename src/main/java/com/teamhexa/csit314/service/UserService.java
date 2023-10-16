package com.teamhexa.csit314.service;

import com.teamhexa.csit314.entity.User;
import com.teamhexa.csit314.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public User saveUser(User user){
        return repo.save(user);
    }

    public List<User> getUsers(){
        return repo.findAll();
    }

    public User getUserById(int id) {
        return repo.findById(id).orElse(null);
    }

    public String deleteUser(int id) {
        repo.deleteById(id);
        return "User removed !! " + id;
    }

    public User updateUser(int id, User user) {
        User existingUser = repo.findById(id).orElse(null);
        existingUser.setUser_name(user.getUser_name());
        existingUser.setFirst_name(user.getFirst_name());
        existingUser.setLast_name(user.getLast_name());
        existingUser.setPassword(user.getPassword());
        existingUser.setProfile_photo(user.getProfile_photo());
        return repo.save(existingUser);
    }
}
