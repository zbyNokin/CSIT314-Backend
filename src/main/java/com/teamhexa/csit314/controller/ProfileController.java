package com.teamhexa.csit314.controller;

import com.teamhexa.csit314.entity.Profile;
import com.teamhexa.csit314.entity.User;
import com.teamhexa.csit314.service.ProfileService;
import com.teamhexa.csit314.EndPointsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfileController {
    @Autowired
    private ProfileService service;
    @GetMapping(EndPointsList.getAllProfile)
    public List<Profile> findAllProfiles(){
        return service.getProfiles();
    }
    @GetMapping(EndPointsList.getProfileById)
    public Profile findProfileById(@PathVariable int id){
        return service.getProfileById(id);
    }
    @PostMapping(EndPointsList.createProfile)
    public Profile addProfile(@RequestBody Profile profile) {
        return service.saveProfile(profile);
    }
    @PutMapping(EndPointsList.getProfileById)
    public Profile updateProfile(@PathVariable int id, @RequestBody Profile profile) {
        return service.updateProfile(id, profile);
    }
    @DeleteMapping(EndPointsList.getProfileById)
    public String deleteProfile(@PathVariable int id) {
        return service.deleteProfile(id);
    }
}
