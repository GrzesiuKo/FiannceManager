package com.pw.controller;

import com.pw.model.Category;
import com.pw.model.Expense;
import com.pw.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
            model.addAttribute("message", "Incorrect Expense Data. Try one more time.");
            return "addExpense";
        }else {
            expense.setDate(new Timestamp(new Date().getTime()));
            expenseService.addExpense(expense);
            System.out.println("Added an expense of: "+expense.getMoney()+" category: "+expense.getCategory().toString());
            model.addAttribute("message", "Your expense was added.");
            return "addExpense";
        }
    }

    @RequestMapping(value = "/expenses", method = RequestMethod.GET)
    public String getExpenses(Model model){
        List<Expense> expenses = expenseService.getExpenses();
        List<Category> categories = expenseService.getCategories();
        model.addAttribute("expenses", expenses);
        return "expenses";
    }

    @RequestMapping(value = "/expense/{id}", method = RequestMethod.GET)
    public @ResponseBody Expense getExpense(@PathVariable("id") Integer id){
        return expenseService.getExpense(id);
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteExpense(@ModelAttribute("expense") Expense expense){
        expenseService.deleteExpense(expense.getId());
        return "delete";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@ModelAttribute("expense") Expense expense){
        return "delete";
    }

    @RequestMapping("/")
    public String home(){
        return "index";
    }

}
