package com.pw.controller.util;

import javax.validation.constraints.NotBlank;

public class CategoryCarriage {

    @NotBlank
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
