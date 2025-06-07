package com.spring.proxylab.lazy.repository;

import com.spring.proxylab.lazy.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
