package com.pw.controller;

import com.pw.model.Expense;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddExpenseController {
    @RequestMapping(value = "/addExpense", method = RequestMethod.GET)
    public String showPage(@ModelAttribute("expense") Expense expense){
        System.out.println("Expense: "+expense.getCost());
        return "addExpense";
    }

    @RequestMapping(value = "/addExpense", method = RequestMethod.POST)
    public String addGoal(@ModelAttribute("expense") Expense expense){
        System.out.println("Added an expense of: "+expense.getCost());
        return "redirect:homesweethome.html";
    }
}
