package com.pennyplanner.splitz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "expenses")
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Column(name = "created_by", nullable = false)
    private Long createdBy;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private String description;

    private String category;

    @Column(name = "currency_code", nullable = false)
    private String currencyCode;

    @Column(name = "expense_date", nullable = false)
    private LocalDateTime expenseDate;

    @Column(nullable = false)
    private String status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public Expense(Group group, Double amount, String description, String currencyCode) {
        this.group = group;
        this.amount = amount;
        this.description = description;
        this.currencyCode = currencyCode;
        this.expenseDate = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
    }

    public Expense(Group group, Double amount, String description, String currencyCode, LocalDateTime expenseDate) {
        this.group = group;
        this.amount = amount;
        this.description = description;
        this.currencyCode = currencyCode;
        this.expenseDate = expenseDate;
        this.createdAt = LocalDateTime.now();
    }
}

