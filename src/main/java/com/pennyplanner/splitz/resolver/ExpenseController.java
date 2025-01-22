package com.pennyplanner.splitz.resolver;

import com.pennyplanner.splitz.model.Expense;
import com.pennyplanner.splitz.service.ExpenseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class ExpenseController {
    @Autowired
    private ExpenseService ExpenseService;

    @QueryMapping
    public Optional<Expense> getExpenseById(@Argument Long ExpenseId) {
        return ExpenseService.getExpenseById(ExpenseId);
    }

}
