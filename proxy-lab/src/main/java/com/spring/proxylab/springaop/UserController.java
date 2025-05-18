package com.spring.proxylab.springaop;

import org.springframework.web.bind.annotation.GetMapping;
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
}
