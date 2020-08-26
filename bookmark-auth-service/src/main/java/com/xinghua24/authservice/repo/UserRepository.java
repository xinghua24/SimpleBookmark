package com.xinghua24.authservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xinghua24.authservice.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
