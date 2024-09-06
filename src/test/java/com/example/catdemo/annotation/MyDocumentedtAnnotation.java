package com.example.catdemo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;


@Target({ElementType.TYPE, ElementType.METHOD})
public @interface MyDocumentedtAnnotation {
    public String value()
        default "这是@Documented注解为文档添加的注释";
}
