package com.shaunabram.handsontable.controller;

import java.io.Serializable;
import java.util.List;

public class Result implements Serializable {
    private static final long serialVersionUID = -5054749880960511861L;
    private int addition;
    private int subtraction;
    private int multiplication;

    private List<Object[]> data;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAddition() { return addition; }
    public void setAddition(int addition) { this.addition = addition; }
    public int getSubtraction() { return subtraction; }
    public void setSubtraction(int subtraction) { this.subtraction = subtraction; }
    public int getMultiplication() { return multiplication; }
    public void setMultiplication(int multiplication) { this.multiplication = multiplication; }

    public List<Object[]> getData() {
        return data;
    }

    public void setData(List<Object[]> data) {
        this.data = data;
    }
}
