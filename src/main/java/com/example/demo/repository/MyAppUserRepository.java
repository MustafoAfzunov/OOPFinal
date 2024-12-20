package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyAppUserRepository extends JpaRepository<com.example.demo.Model.MyAppUser, Long>{

    Optional<com.example.demo.Model.MyAppUser> findByUsername(String username);
    Optional<com.example.demo.Model.MyAppUser> findByEmail(String email);
}
