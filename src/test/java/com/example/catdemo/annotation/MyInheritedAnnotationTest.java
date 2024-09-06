package com.example.catdemo.annotation;

public class MyInheritedAnnotationTest extends Parent{
    public static void main(String[] args) {
        Class<MyInheritedAnnotationTest> child=MyInheritedAnnotationTest.class;
        MyInheritedAnnotation annotation = child.getAnnotation(MyInheritedAnnotation.class);
        System.out.println(annotation.name());
    }
}
