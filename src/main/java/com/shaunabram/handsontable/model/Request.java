package com.shaunabram.handsontable.model;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("unused")
public class Request implements Serializable {
    private String description;
    private List<Object[]> data;

    public Request() {}

    public Request(String description, List<Object[]> data) {
        this.description = description;
        this.data = data;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Object[]> getData() {
        return data;
    }

    public void setData(List<Object[]> data) {
        this.data = data;
    }
}
