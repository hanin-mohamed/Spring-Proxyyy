package com.spring.proxylab.transactional.controller;

import com.spring.proxylab.transactional.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proxy")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/check-proxy")
    public String checkProxy() {
        System.out.println(" Injected bean class: " + userService.getClass());
        return "Check the console!";
    }

    @PostMapping("/test-transaction")
    public String testTransaction() {
        try {
            userService.createUsersWithRollback();
        } catch (Exception e) {
            return " Exception caught: " + e.getMessage();
        }
        return " Done";
    }
    @GetMapping("/async-create-user")
    public String asyncCreateUser() {
        userService.createUserAsync();
        return "Started async user creation";
    }

}
