package com.pw.controller;

import com.pw.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StatisticsController {

    @Autowired
    StatisticsService statisticsService;

    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public String getStatistics(Model model){
        model.addAttribute("statistics", statisticsService.getStatistics());
        return "statistics";
    }

}
