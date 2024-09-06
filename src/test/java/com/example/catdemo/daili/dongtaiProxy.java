package com.example.catdemo.daili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class dongtaiProxy implements InvocationHandler {
    private Object bean;
    public dongtaiProxy(Object bean) {
        this.bean = bean;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if (methodName.equals("sayHello")){
            System.out.println("早安~~~");
        }
        return method.invoke(bean, args);
    }
}
