package com.pennyplanner.splitz.repository;

import com.pennyplanner.splitz.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
