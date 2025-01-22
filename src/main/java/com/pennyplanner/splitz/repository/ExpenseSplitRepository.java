package com.pennyplanner.splitz.repository;

import com.pennyplanner.splitz.model.Expense;
import com.pennyplanner.splitz.model.ExpenseSplit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpenseSplitRepository extends JpaRepository<ExpenseSplit, Long> {
    @Query("SELECT es.expense FROM ExpenseSplit es WHERE es.user.id = :userId")
    List<Expense> findExpensesByUserId(@Param("userId") Long userId);
}
