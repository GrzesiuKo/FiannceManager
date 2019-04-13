package com.pw.model;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

public class Expense {
    @NotNull
    private Category category;
    @Range(min = 0,max = 100000000)
    private double cost;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
