package com.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by manask on 12-02-2017.
 */
public class LoggingAspect {

    public  void loggingAdvise(JoinPoint joinPoint){
        System.out.println("Advise Method Called for "+joinPoint.toString());
    }

    @Before("allCircleMethod()")
    public void secondAdvise(){
        System.out.println("Second Advise Method Called");
    }

    @Before("args(name)")
    public void stringArgMethod(String name){
        System.out.println("Method Arg advise method called, and the value is "+name);
    }

    @AfterReturning(pointcut = "args(name)", returning = "returnValue")
    public void afterMethod(String name, String returnValue){
        System.out.println("After Advise called, the return value is "+returnValue);
    }

    @AfterThrowing(pointcut = "args(name)", throwing = "exp")
    public void afterExecException(String name, Exception exp){
        System.out.println("An exception has been thrown "+exp);
    }

    @Around("@annotation(com.aop.aspect.Loggable)")
    public Object aroundAdvise(ProceedingJoinPoint proceedingJoinPoint){
        Object obj = null;
        try {
            System.out.println("Before Around advise");
            obj = proceedingJoinPoint.proceed();
            System.out.println("After Around Advise");
        } catch (Throwable throwable) {
            System.out.println("Exception Occured");
        }
        System.out.println("Executed successfully");

        return obj;
    }

    @Pointcut("within(com.aop.model.Circle)")
    public void allCircleMethod(){}
}
