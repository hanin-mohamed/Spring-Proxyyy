package com.spring.proxylab.springaop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public User(String name) {
        this.name = name;
    }
}