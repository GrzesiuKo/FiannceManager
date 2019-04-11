package com.pw.controller;

import com.pw.model.Expense;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddExpenseController {
    @RequestMapping(value = "/addExpense")
    public String addExpense(@ModelAttribute("expense") Expense expense){
        System.out.println("Expense: "+expense.getCost());
        return "addExpense";
    }
}
