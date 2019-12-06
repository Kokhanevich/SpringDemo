package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> getAllUsers();

    void delete(Long id);
}
