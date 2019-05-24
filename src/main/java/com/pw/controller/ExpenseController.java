package com.pw.controller;

import com.pw.controller.util.IdCarriage;
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
    public String getExpense(@ModelAttribute("expense") Expense expense, Model model){

        List<Category> categories = expenseService.getCategories();
        model.addAttribute("categories", categories);

        return "addExpense";
    }

    @RequestMapping(value = "/addExpense", method = RequestMethod.POST)
    public String addExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model){

        List<Category> categories = expenseService.getCategories();
        model.addAttribute("categories", categories);

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


    @RequestMapping(value = "/expense/{id}", method = RequestMethod.GET)
    public @ResponseBody Expense getExpense(@PathVariable("id") Integer id){
        return expenseService.getExpense(id);
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteExpense(@Valid @ModelAttribute("expense") IdCarriage expense, BindingResult result, Model model){
        System.out.println("Wartosć:" + expense.getId());
        if (result.hasErrors()){
            model.addAttribute("message", "Expense under this ID was NOT deleted.");
            System.out.println(result.getAllErrors().toString());
        }else{
            model.addAttribute("message", "Expense under ID "+expense.getId()+" was deleted.");
            expenseService.deleteExpense(expense.getId());
        }
        return "delete";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@ModelAttribute("expense") IdCarriage expense){
        return "delete";
    }

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public @ResponseBody List<Category> getCategories(){
        return expenseService.getCategories();
    }

}
