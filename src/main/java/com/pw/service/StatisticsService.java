package com.pw.service;

import com.pw.model.Expense;
import com.pw.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticsService {

    @Autowired
    ExpenseRepository expenseRepository;

    public List<List<Map<Object,Object>>> getStatistics(){
        List<List<Map<Object,Object>>> list = new ArrayList<>();
        List<Expense> expenses = expenseRepository.getExpenses();
        Map<Object,Object> stats = countStatistics(expenses);
        Map<Object,Object> map;
        List<Map<Object,Object>> dataPoints = new ArrayList<>();

        for (Object category: stats.keySet()) {
            map = new HashMap<>();
            map.put("label", category);
            map.put("y", stats.get(category));
            dataPoints.add(map);
        }

        list.add(dataPoints);

        return list;
    }

    private Map<Object,Object> countStatistics(List<Expense> expenses){
        Map<Object,Object> stats = new HashMap<>();

        for (Expense expense : expenses) {
            stats = update(stats, expense);
        }
        return stats;
    }

    private Map<Object, Object> update(Map<Object,Object> stats, Expense expense) {
        String category = expense.getCategory();
        double value;
        if (stats.containsKey(category)){
            value = (double) stats.get(category);
            value+=expense.getMoney();
            stats.put(category,value);
        }else{
            stats.put(category,expense.getMoney());
        }
        return stats;
    }
}
