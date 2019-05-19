package com.pw.service;

import com.pw.model.Expense;
import com.pw.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("modifyExpenseService")
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    public Expense addExpense(Expense expense) {

        return expenseRepository.addExpense(expense);
    }

    public List<Expense> getExpenses() {
        return expenseRepository.getExpenses();
    }
}
