package com.njupt.community.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 是否需要登录才可以访问的注解
 */
@Target(ElementType.METHOD)//注解可以描述方法
@Retention(RetentionPolicy.RUNTIME)//运行时有效
public @interface LoginRequired {
}
