package com.example.demo.controller;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/inject")
public class InjectDataController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostConstruct
    @GetMapping
    public void injectData() {

        Role user = new Role("USER");
        roleService.save(user);
        Role admin = new Role("ADMIN");
        roleService.save(admin);

        User adminVasia = new User("admin", "admin", "Vasia");
        Role roleAdmin = roleService.findRoleByName("ADMIN")
                .orElseThrow(() -> new NoSuchElementException("Can’t find this role"));
        adminVasia.setRoles(Arrays.asList(roleAdmin));
        userService.save(adminVasia);

        User userKolia = new User("user", "user", "Kolia");
        Role roleUser = roleService.findRoleByName("USER")
                .orElseThrow(() -> new NoSuchElementException("Can’t find this role"));
        userKolia.setRoles(Arrays.asList(roleUser));
        userService.save(userKolia);
    }

}
