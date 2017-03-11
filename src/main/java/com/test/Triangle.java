package com.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by manask on 23-01-2017.
 */
public class Triangle implements ApplicationContextAware , BeanNameAware , Shape{

    public Point point0;
    public Point point1;
    public Point point2;

    ApplicationContext applicationContext = null;

    public Point getPoint0() {
        return point0;
    }

    public void setPoint0(Point point0) {
        this.point0 = point0;
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public void draw(){
        System.out.println("Triangle draw");
        point0= (Point) applicationContext.getBean("point0");
        setBeanName("point0");
        System.out.println("Point 0 {"+point0.getX()+" ,"+point0.getY()+" }");
        System.out.println("Point 1 {"+point1.getX()+" ,"+point1.getY()+" }");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Application context");
        this.applicationContext = applicationContext;
    }

    public void setBeanName(String beanName) {
        System.out.println("Bean Name "+beanName);
    }

    public void myInit(){
        System.out.println("MyInit method call for triangle");
    }

    public void myDestroy(){
        System.out.println("MyDestroy method called fo Triangle");
    }
}
