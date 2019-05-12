package com.pw.controller;

import com.pw.model.Expense;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class AddExpenseController {
    @RequestMapping(value = "/addExpense", method = RequestMethod.GET)
    public String showPage(@ModelAttribute("expense") Expense expense){
        System.out.println("Expense: "+expense.getMoney());
        return "addExpense";
    }

    @RequestMapping(value = "/addExpense", method = RequestMethod.POST)
    public String addGoal(@Valid @ModelAttribute("expense") Expense expense, BindingResult result){

        if (result.hasErrors()){
            return "addExpense";
        }else {
            System.out.println("Added an expense of: "+expense.getMoney()+" category: "+expense.getCategory().toString());
            return "redirect:homesweethome.html";
        }
    }
}
