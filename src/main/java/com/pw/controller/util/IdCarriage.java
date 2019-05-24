package com.pw.controller.util;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

public class IdCarriage {

    @NotNull
    @Range
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
