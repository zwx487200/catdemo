package com.example.catdemo.daili;

public class TestServiceImpl implements TestService{
    @Override
    public String sayHello(String name) {
        System.out.println("fuck the world " + name);
        return "fuck the world" + name;
    }
}
