package com.teamhexa.csit314.service;

import com.teamhexa.csit314.entity.Profile;
import com.teamhexa.csit314.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfileService {
    @Autowired
    private ProfileRepository repo;
    public Profile saveProfile(Profile profile){
        return repo.save(profile);
    }
    public List<Profile> getProfiles(){
        return repo.findAll();
    }
    public Profile getProfileById(int id) {
        return repo.findById(id).orElse(null);
    }
    public String deleteProfile(int id) {
        repo.deleteById(id);
        return "Profile removed !!" + id;
    }
    public Profile updateProfile(int id, Profile profile) {
        Profile existingProfile = repo.findById(id).orElse(null);
        existingProfile.setProfile_name(profile.getProfile_name());
        existingProfile.setProfile_desc(profile.getProfile_desc());
        return repo.save(existingProfile);
    }
}
