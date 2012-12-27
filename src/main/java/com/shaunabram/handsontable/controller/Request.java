package com.shaunabram.handsontable.controller;

import java.io.Serializable;
import java.util.List;

public class Request implements Serializable {
    private static final long serialVersionUID = 1513207428686438208L;
    private int left;
    private int right;
    private Object[] a;
    private String description;
    private List<Object[]> data;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object[] getA() {
        return a;
    }

    public void setA(Object[] a) {
        this.a = a;
    }

    public List<Object[]> getData() {
        return data;
    }

    public void setData(List<Object[]> data) {
        this.data = data;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }
}
