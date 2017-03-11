package com.test;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

/**
 * Created by manask on 28-01-2017.
 */
public class Square implements InitializingBean, DisposableBean , Shape{
    public List<Point> points;

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public void draw(){
        System.out.println("Square points");
        for(Point point : points){
            System.out.println("Point { "+point.getX()+" ,"+point.getY()+" }");
        }
    }

    public void destroy() throws Exception {
        System.out.println("Disposable destroy Method called for square");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean init Method called for square");
    }

    public void myInit(){
        System.out.println("MyInit method call for Square");
    }

    public void myDestroy(){
        System.out.println("MyDestroy method called fo Square");
    }
}
