package com.aop.services;

import com.aop.aspect.Loggable;
import com.aop.model.Circle;
import com.aop.model.Triangle;

/**
 * Created by manask on 12-02-2017.
 */
public class ShapeServices {
    private Triangle triangle;
    private Circle circle;

    public Triangle getTriangle() {
        return triangle;
    }

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }

    @Loggable
    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }
}
