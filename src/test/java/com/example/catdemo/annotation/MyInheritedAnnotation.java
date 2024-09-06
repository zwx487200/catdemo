package com.example.catdemo.annotation;

import java.lang.annotation.*;



@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyInheritedAnnotation {
    public String name() default "longAoTian";
}
