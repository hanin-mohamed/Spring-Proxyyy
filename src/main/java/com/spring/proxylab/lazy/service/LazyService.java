package com.spring.proxylab.lazy.service;


import com.spring.proxylab.lazy.entity.Author;
import com.spring.proxylab.lazy.repository.AuthorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LazyService {

    @Autowired
    private  AuthorRepository authorRepository;

    @Transactional
    public void loadAuthorAndBooks(Long authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Not found"));

        System.out.println("Author name: " + author.getName());
        System.out.println("Books: " + author.getBooks()); // Proxy here!
    }

    public void loadOutsideTransaction(Long authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Not found"));

        System.out.println("Author name: " + author.getName());
        // This will throw LazyInitializationException
        System.out.println("Books: " + author.getBooks().size());
    }

}
