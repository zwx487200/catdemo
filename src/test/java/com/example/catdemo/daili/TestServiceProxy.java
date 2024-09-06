package com.example.catdemo.daili;

public class TestServiceProxy implements TestService{
    private TestServiceImpl testService;

    public TestServiceProxy(TestServiceImpl testService) {
        this.testService=testService;
    }

    @Override
    public String sayHello(String name) {
        System.out.println("世界美好");
        String mySay= testService.sayHello(name);
        System.out.println("为啥要这样做");
        return mySay;
    }
}
