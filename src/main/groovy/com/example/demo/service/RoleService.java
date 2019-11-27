package com.example.demo.service;

import com.example.demo.model.Role;

import java.util.Optional;

public interface RoleService {

    Role save(Role role);

    Optional<Role> findRoleByName(String name);
}
