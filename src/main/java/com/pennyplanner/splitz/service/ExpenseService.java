package com.pennyplanner.splitz.service;

import com.pennyplanner.splitz.model.Expense;
import com.pennyplanner.splitz.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    private final ExpenseRepository ExpenseRepository;

    public ExpenseService(ExpenseRepository ExpenseRepository) {
        this.ExpenseRepository = ExpenseRepository;
    }

    public Expense createExpense(String name) {
        Expense Expense = new Expense();
        Expense.setDescription(name);
        return ExpenseRepository.save(Expense);
    }

    public Optional<Expense> getExpenseById(Long id) {
        return ExpenseRepository.findById(id);
    }

    public List<Expense> getAllExpenses() {
        return ExpenseRepository.findAll();
    }

    public Expense updateExpense(Long id, Double amount, String description, String currencyCode) {
        Expense Expense = ExpenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        Expense.setAmount(amount);
        Expense.setDescription(description);
        Expense.setCurrencyCode(currencyCode);

        return ExpenseRepository.save(Expense);
    }

    public void deleteExpense(Long id) {
        if (!ExpenseRepository.existsById(id)) {
            throw new RuntimeException("Expense not found");
        }
        ExpenseRepository.deleteById(id);
    }
}

