package com.shaunabram.handsontable.model;

import java.io.Serializable;
import java.util.List;

public class Result implements Serializable {
    private final List<Object[]> data;
    private final String description;

    public Result(String description, List<Object[]> data) {
        this.data = data;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public List<Object[]> getData() {
        return data;
    }
}
