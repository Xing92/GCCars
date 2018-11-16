package com.xing.gccars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xing.gccars.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

	public User findByUsername(String username);

}
