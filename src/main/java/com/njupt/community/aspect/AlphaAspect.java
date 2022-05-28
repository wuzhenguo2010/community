package com.njupt.community.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class AlphaAspect {

    @Pointcut("execution(* com.njupt.community.service.*.*(..))")//第一个*代表不管方法返回值, 后面路径表示service包下的所有组件的所有方法的所有参数都处理
    public void pointcut(){

    }

    @Before("pointcut()")//在连接点一开始处理
    public void before(){
        System.out.println("before");
    }

    @After("pointcut()")
    public void after(){
        System.out.println("after");
    }

    @AfterReturning("pointcut()") //有了返回值以后
    public void afterReturning(){
        System.out.println("afterReturning");
    }

    @AfterThrowing("pointcut()") //抛异常的时候
    public void afterThrowing(){
        System.out.println("afterThrowing");
    }

    @Around("pointcut()") //前后都织入逻辑
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("around before");
        Object obj = joinPoint.proceed();//调用目标组件方法
        System.out.println("around after");
        return obj;
    }


}
