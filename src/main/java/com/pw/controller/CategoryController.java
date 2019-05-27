package com.pw.controller;

import com.pw.controller.util.CategoryCarriage;
import com.pw.controller.util.IdCarriage;
import com.pw.model.Category;
import com.pw.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/addCategory", method = RequestMethod.GET)
    public String category(@ModelAttribute("expense") CategoryCarriage expense){
        return "addCategory";
    }

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("expense") CategoryCarriage category, Model model){

        categoryService.addCategory(category.getCategory());
        model.addAttribute("message", "Your CATEGORY was added.");
        return "addCategory";
    }

    @RequestMapping(value = "/deleteCategory", method = RequestMethod.POST)
    public String deleteExpense(@Valid @ModelAttribute("category") IdCarriage category, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("message", "Category under this ID was NOT deleted.");
        }else{
            model.addAttribute("message", "Category under ID "+category.getId()+" was deleted.");
            categoryService.deleteCategory(category.getId());
        }
        return "deleteCategory";
    }

    @RequestMapping(value = "/deleteCategory", method = RequestMethod.GET)
    public String delete(@ModelAttribute("category") IdCarriage expense){
        return "deleteCategory";
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public String getExpenses(Model model){
        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);
        return "categories";
    }

}
