package com.pw.model;

import org.hibernate.validator.constraints.Range;

import java.sql.Date;

public class Expense {
    private Date date;
    private int id;
    private String category;
    @Range(min = 0,max = 100000000)
    private double money;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
