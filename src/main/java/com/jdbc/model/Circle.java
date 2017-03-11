package com.jdbc.model;

/**
 * Created by manask on 04-03-2017.
 */
public class Circle {
    public Long id;
    public String name;

    public Circle() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Circle(Long id, String name){
        setId(id);
        setName(name);
    }
}
