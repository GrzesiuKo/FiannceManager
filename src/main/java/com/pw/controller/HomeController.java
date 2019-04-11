package com.pw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    @RequestMapping(value = "home")
    public String welcome(Model model){
        model.addAttribute("Welcome");
        return "home";
    }
}
