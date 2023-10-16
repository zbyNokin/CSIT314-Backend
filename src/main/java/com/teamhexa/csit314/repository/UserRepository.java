package com.teamhexa.csit314.repository;

import com.teamhexa.csit314.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
}
