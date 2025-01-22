package com.pennyplanner.splitz.service;

import com.pennyplanner.splitz.model.Expense;
import com.pennyplanner.splitz.model.ExpenseSplit;
import com.pennyplanner.splitz.model.User;
import com.pennyplanner.splitz.repository.ExpenseSplitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseSplitService {
    private final ExpenseSplitRepository ExpenseSplitRepository;

    public ExpenseSplitService(ExpenseSplitRepository ExpenseSplitRepository) {
        this.ExpenseSplitRepository = ExpenseSplitRepository;
    }

    public ExpenseSplit createExpenseSplit(User user, Expense expense, Double amount, String splitType, Long shares, Double percentage) {
        ExpenseSplit ExpenseSplit = new ExpenseSplit();
        return ExpenseSplitRepository.save(ExpenseSplit);
    }

    public Optional<ExpenseSplit> getExpenseSplitById(Long id) {
        return ExpenseSplitRepository.findById(id);
    }

    public List<ExpenseSplit> getAllExpenseSplits() {
        return ExpenseSplitRepository.findAll();
    }

    public ExpenseSplit updateExpenseSplit(Long id, User user, Expense expense, Double amount, String splitType, Long shares, Double percentage) {
        ExpenseSplit ExpenseSplit = ExpenseSplitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ExpenseSplit not found"));

        ExpenseSplit.setUser(user);
        ExpenseSplit.setExpense(expense);

        if(amount >= 0) {
            ExpenseSplit.setPaidAmount(amount);
        } else {
            ExpenseSplit.setOwedAmount(amount);
        }

        ExpenseSplit.setSplitType(splitType);
        ExpenseSplit.setShares(shares);
        ExpenseSplit.setPercentage(percentage);

        return ExpenseSplitRepository.save(ExpenseSplit);
    }

    public void deleteExpenseSplit(Long id) {
        if (!ExpenseSplitRepository.existsById(id)) {
            throw new RuntimeException("ExpenseSplit not found");
        }
        ExpenseSplitRepository.deleteById(id);
    }

    public List<Expense> getExpensesByUserId(Long userId) {
        return ExpenseSplitRepository.findExpensesByUserId(userId);
    }
}

