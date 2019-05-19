package com.pw.controller;

import com.pw.model.Expense;
import com.pw.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @RequestMapping(value = "/addExpense", method = RequestMethod.GET)
    public String getExpense(@ModelAttribute("expense") Expense expense){
        return "addExpense";
    }

    @RequestMapping(value = "/addExpense", method = RequestMethod.POST)
    public String addExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model){

        if (result.hasErrors()){
            System.out.println("Errors while adding Expense "+result.getModel().toString());
            model.addAttribute("fail_message", "Incorrect Expense Data. Try one more time.");
            return "addExpense";
        }else {
            expense.setDate(new Timestamp(new Date().getTime()));
            expenseService.addExpense(expense);
            System.out.println("Added an expense of: "+expense.getMoney()+" category: "+expense.getCategory().toString());
            return "redirect:homesweethome.html";
        }
    }

    @RequestMapping(value = "/expenses", method = RequestMethod.GET)
    public @ResponseBody List<Expense> getExpenses(){
        System.out.println("EHOOOOOOOOO !!!!!!");
        return expenseService.getExpenses();
    }
}
