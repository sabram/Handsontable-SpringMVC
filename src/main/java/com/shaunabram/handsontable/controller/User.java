package com.shaunabram.handsontable.controller;

import java.util.Arrays;

public class User {
    private String name = null;
    private String education = null;
    private Object[] tableData = null;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEducation() {
        return education;
    }
    public void setEducation(String education) {
        this.education = education;
    }

    public Object[] getTableData() {
        return tableData;
    }

    public void setTableData(Object[] tableData) {
        this.tableData = tableData;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", education='" + education + '\'' +
                ", tableData=" + (tableData == null ? null : Arrays.asList(tableData)) +
                '}';
    }
}
