package com.Demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.Demo.User.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

    UserDetails findByLogin(String username); 
}



