package com.example.catdemo.daili.dongtaidaili;

import com.example.catdemo.daili.TestService;
import com.example.catdemo.daili.TestServiceImpl;
import com.example.catdemo.daili.dongtaiProxy;

import java.lang.reflect.Proxy;

public class dongtaiProxyTest {
    public static void main(String[] args) {
        dongtaiProxy dongtaiProxy = new dongtaiProxy(new TestServiceImpl());
        TestService testService = (TestService) Proxy.newProxyInstance(dongtaiProxy.getClass().getClassLoader(), new Class[]{TestService.class}, dongtaiProxy);
        testService.sayHello("LongAoTian");
    }
}
