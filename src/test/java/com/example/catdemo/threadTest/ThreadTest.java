package com.example.catdemo.threadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);


        Thread thread001 = new Thread("ceshi001"){
            @Override
            public void run() {
                try {
                    sleep(100);
                    System.out.println(Thread.currentThread().getName() +" is running");
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread thread002 = new Thread("ceshi001"){
            @Override
            public void run() {
                try {
                    sleep(100);
                    System.out.println(Thread.currentThread().getName() +" is running");
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        thread001.start();
        thread002.start();

        System.out.println("Main thread ends");
    }
}
