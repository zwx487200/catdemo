package com.example.catdemo.annotation;


import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MyRepeatableAnnotationTest {
    @Test
    public void testValue() {
        Method[] methods = MyRepeatable.class.getMethods();
        for (Method method : methods){
            if (method.getName().equals("test")) {
                Annotation[] annotations = method.getDeclaredAnnotations();
                System.out.println(annotations.length);
                System.out.println(method.getName() + " = " + Arrays.toString(annotations));
            }
        }
    }
}

class MyRepeatable {
    @MyRepeatableAnnotation(name = "hello")
    @MyRepeatableAnnotation(name = "world")
    public void test(String var1, String var2, String var3) {
        System.out.println(var1 + " " + var2);
    }
}
