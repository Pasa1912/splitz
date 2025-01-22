package com.pennyplanner.splitz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name="expense_splits")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ExpenseSplit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "expense_id", nullable = false)
    private Expense expense;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name="owed_amount")
    private Double owedAmount;

    @Column(name="paid_amount")
    private Double paidAmount;

    @Column(name="split_type", nullable = false)
    private String splitType;

    private Long shares;

    private Double percentage;
}
