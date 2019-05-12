package com.pw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MenuController {

    @RequestMapping(value = "/homesweethome")
    public String welcome(Model model){
        model.addAttribute("greeting", "Dear User");
        return "home";
    }
}
