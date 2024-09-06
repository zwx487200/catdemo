package com.example.catdemo.annotation;

import java.lang.annotation.*;


@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyRepeatableAnnotations.class)
public @interface MyRepeatableAnnotation {
    String name() default "longAoTian";
}
