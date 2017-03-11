package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by manask on 04-02-2017.
 */
@Controller
public class Circle implements Shape {
    Point center;
    Point circlePoint;

    public Point getCirclePoint() {
        return circlePoint;
    }

    @Resource(name = "point1")
    public void setCirclePoint(Point circlePoint) {
        this.circlePoint = circlePoint;
    }

    public Point getCenter() {
        return center;
    }

    @Autowired
    @Qualifier("circleQualifier")
    public void setCenter(Point center) {
        this.center = center;
    }



    public void draw() {
        System.out.println("Circle center { "+center.getX()+" ,"+center.getY()+" }");
        System.out.println("Circle point { "+circlePoint.getX()+" ,"+circlePoint.getY()+" }");
    }
}
