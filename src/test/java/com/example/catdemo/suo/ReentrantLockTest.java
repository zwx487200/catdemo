package com.example.catdemo.suo;

import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class ReentrantLockTest {
    private static final ReentrantLock reentrantLockNoFair = new ReentrantLock(false);
    private static final ReentrantLock reentrantLockFair = new ReentrantLock(true);
    private static long cnt = 0;
    public static void testReentrantLockNoFair(int a) throws InterruptedException {
        sleep(100);
        reentrantLockNoFair.lock();
        System.out.println("第"+ a + "次锁");
        doSomething();
        sleep(5000);
        reentrantLockNoFair.unlock();
        System.out.println("第"+ a + "释放次锁");
    }
    public static void testReentrantLockFair(int a) throws InterruptedException {
        sleep(100);
        reentrantLockFair.lock();
        System.out.println("第"+ a + "次锁");
        doSomething();
        sleep(5000);
        reentrantLockFair.unlock();
        System.out.println("第"+ a + "释放次锁");
    }
    private static void doSomething() throws InterruptedException {
        cnt += 1;
        if (cnt >= (Long.MAX_VALUE >> 1)) {
            cnt = 0;
        }
        sleep(1);
    }
    public static void main(String[] args) throws InterruptedException {
        for (int a = 0; a < 5; a++) {
            int finalA = a;
            Thread thread = new Thread(() -> {
                try {
                    System.out.println("线程" + finalA + "启动");
                    testReentrantLockNoFair(finalA);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }


//    private static final ReentrantLock lock = new ReentrantLock(true);
//
//    public static void main(String[] args) {
//        // 定义线程任务
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                // 加锁
//                lock.lock();
//                try {
//                    // 打印执行线程的名字
//                    System.out.println("线程:" + Thread.currentThread().getName());
//                } finally {
//                    // 释放锁
//                    lock.unlock();
//                }
//            }
//        };
//        // 创建多个线程
//        for (int i = 0; i < 10; i++) {
//            new Thread(runnable).start();
//        }
//    }
}
