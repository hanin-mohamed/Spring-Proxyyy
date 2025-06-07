package com.spring.proxylab.transactional.repository;


import com.spring.proxylab.transactional.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}