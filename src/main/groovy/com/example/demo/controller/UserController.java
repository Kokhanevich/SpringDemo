package com.example.demo.controller;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
public class UserController {
    public static final String ROLE_NAME = "USER";

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

//    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public void addUser(@RequestBody User user) {
        Role role = roleService.findRoleByName(ROLE_NAME)
                .orElseThrow(() -> new NoSuchElementException("Can’t find this role"));
        user.setRoles(Arrays.asList(role));
        userService.save(user);
    }

//    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping("/{userId}")
    public void delete(@PathVariable("userId") Long id) {
        userService.delete(id);
    }
}
