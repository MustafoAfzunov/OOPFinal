package com.example.demo.service;

import com.example.demo.repository.IncomeRepository;
import com.example.demo.repository.ExpenseRepository;
import com.example.demo.Model.MyAppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceService {

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    public Double calculateBalance(MyAppUser user) {
        Double totalIncome = incomeRepository.findByUser(user)
                .stream()
                .mapToDouble(com.example.demo.Model.Income::getAmount)
                .sum();

        Double totalExpense = expenseRepository.findByUser(user)
                .stream()
                .mapToDouble(com.example.demo.Model.Expense::getAmount)
                .sum();

        return totalIncome - totalExpense;
    }
}
