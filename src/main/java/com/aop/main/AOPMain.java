package com.aop.main;

import com.aop.services.ShapeServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by manask on 12-02-2017.
 */
public class AOPMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_aop.xml");
        ShapeServices shapeServices = context.getBean("shapeservice", ShapeServices.class);
        shapeServices.getCircle();
        //System.out.println(shapeServices.getTriangle().getName());
    }
}
