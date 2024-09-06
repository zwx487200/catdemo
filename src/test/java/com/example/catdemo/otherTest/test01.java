package com.example.catdemo.otherTest;

import java.util.concurrent.atomic.AtomicInteger;

public class test01 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        System.out.println(atomicInteger.compareAndSet(1, 2));
        System.out.println(atomicInteger);
    }

}
