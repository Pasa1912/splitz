package com.pennyplanner.splitz.resolver;

import com.pennyplanner.splitz.model.Expense;
import com.pennyplanner.splitz.service.ExpenseSplitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ExpenseSplitController {
    @Autowired
    private ExpenseSplitService expenseSplitService;

    @QueryMapping
    public List<Expense> getExpensesByUserId(@Argument Long userId) {
        return expenseSplitService.getExpensesByUserId(userId);
    }
}
