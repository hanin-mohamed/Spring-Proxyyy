package com.spring.proxylab.springaop.repository;


import com.spring.proxylab.springaop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}