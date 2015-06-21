package com.ontarget.enums;

/**
 * Created by sanjeevghimire on 6/19/15.
 */
public enum ProjectUOM {

    HOUR("Hour","hr"),
    DOLLAR("Dollar","$");

    private String symbol;
    private String name;

    ProjectUOM(String name, String symbol) {
        this.name=name;
        this.symbol=symbol;

    }
}
