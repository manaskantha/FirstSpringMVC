package com.test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.FileSystemResource;

/**
 * Created by manask on 23-01-2017.
 */
public class DrawingApp {

    public static void main(String[] args) {
        //BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        context.registerShutdownHook();
        Shape shape = (Shape) context.getBean("triangle");
        Shape shape1 = (Shape) context.getBean("square-alias");
        Shape shape2 = (Shape) context.getBean("circle");
        shape.draw();
        shape1.draw();
        shape2.draw();

        System.out.println("Printing Message from properties file--- "
                +context.getMessage("greeting", null, "Default Message", null));
        //Square square = (Square) context.getBean("square-alias");
        //square.draw();
    }

}
