package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<com.example.demo.Model.Income, Long> {
    List<com.example.demo.Model.Income> findByUser(com.example.demo.Model.MyAppUser user);
}
