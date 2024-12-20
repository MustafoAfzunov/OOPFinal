package com.example.demo.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String source; // e.g., Salary, Freelance, etc.

    private Double amount;

    private LocalDate date;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private com.example.demo.Model.MyAppUser user;

    // Constructors

    public Income() {}

    public Income(String source, Double amount, LocalDate date, com.example.demo.Model.MyAppUser user) {
        this.source = source;
        this.amount = amount;
        this.date = date;
        this.user = user;
    }
    @PrePersist
    public void prePersist() {
        if (this.date == null) {
            this.date = LocalDate.now(); // Automatically set the current date
        }
    }



    public void setUser(com.example.demo.Model.MyAppUser user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Getters and Setters
    // ... (include all getters and setters)

}
