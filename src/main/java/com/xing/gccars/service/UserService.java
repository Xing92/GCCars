package com.xing.gccars.service;

import com.xing.gccars.exception.UserNotFoundException;
import com.xing.gccars.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User save(User user);

    User findByUserId(Long id) throws UserNotFoundException;

    User findByUsername(String username) throws UserNotFoundException;

    void deleteById(Long id) throws UserNotFoundException;
}
