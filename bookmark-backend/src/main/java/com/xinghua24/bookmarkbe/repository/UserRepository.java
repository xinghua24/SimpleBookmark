package com.xinghua24.bookmarkbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xinghua24.bookmarkbe.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
