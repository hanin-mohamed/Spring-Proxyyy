package com.spring.proxylab.lazy.repository;

import com.spring.proxylab.lazy.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
