package com.aop.model;

/**
 * Created by manask on 12-02-2017.
 */
public class Circle {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Circle SetName() called, and the value is "+name);
        throw(new RuntimeException());
    }

    public String setParamValue(String value){
        this.name = value;
        System.out.println("Circle setParamValue() called, and the value is "+name);
        return name;
    }
}
