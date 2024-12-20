package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<com.example.demo.Model.Expense, Long> {
    List<com.example.demo.Model.Expense> findByUser(com.example.demo.Model.MyAppUser user);
}
