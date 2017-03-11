package com.jdbc.main;

import com.jdbc.dao.CircleImpl;
import com.jdbc.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.DriverManager;

/**
 * Created by manask on 04-03-2017.
 */
public class JDBCMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_jdbc.xml");
        CircleImpl circleImpl = context.getBean("circleImpl", CircleImpl.class);
       //Circle cl =  circleImpl.getCircle(1L);

        //System.out.println("No of circle "+circleImpl.getCircleCount());
        /*System.out.println("Name of circle "+circleImpl.getCircleName(1L));*/
        circleImpl.addCircle(new Circle(0L, "demo Circle"));

        //System.out.println("Size of circle "+circleImpl.getAllCircle().size());

    }
}
