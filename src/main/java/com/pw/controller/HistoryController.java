package com.pw.controller;

import com.pw.model.Expense;
import com.pw.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HistoryController {

    @Autowired
    ExpenseService expenseService;

    @RequestMapping(value = "/expenses", method = RequestMethod.GET)
    public String getExpenses(Model model){
        List<Expense> expenses = expenseService.getExpenses();
        model.addAttribute("expenses", expenses);
        return "expenses";
    }
}
