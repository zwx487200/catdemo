package com.example.catdemo.daili.jingtaidaili;

import com.example.catdemo.daili.TestServiceImpl;
import com.example.catdemo.daili.TestServiceProxy;

public class jingtaiProxyTest {
        public static void main(String[] args) {
            TestServiceImpl testService = new TestServiceImpl();
            TestServiceProxy proxy = new TestServiceProxy(testService);
            proxy.sayHello("LongAoTian");
        }
}




