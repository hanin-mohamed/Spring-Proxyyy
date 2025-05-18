package com.spring.proxylab.service;

import com.spring.proxylab.springaop.entity.User;
import com.spring.proxylab.springaop.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    // No user will be saved in the database because of the exception
    public void createUsersWithRollback() {
        User user1 = new User(null, "Haneen");
        userRepository.save(user1);
        System.out.println(" User 1 saved!");

        if (true) throw new RuntimeException(" Simulated error");

        User user2 = new User(null, "Mohamed");
        userRepository.save(user2);
    }
}
