package com.example.catdemo.threadPoolTest;

import java.util.concurrent.*;

public class myThreadPoolTest {
    ExecutorService Fixedexecutor = Executors.newFixedThreadPool(2);
    ExecutorService CachedExecutor = Executors.newCachedThreadPool();
    ExecutorService ScheduledExecutor = Executors.newScheduledThreadPool(2);
    ExecutorService SingleThreadExecutor = Executors.newSingleThreadExecutor();
    ExecutorService ForkJoinPool = Executors.newWorkStealingPool();

    public static void main(String[] args) {
        ExecutorService Fixedexecutor = Executors.newFixedThreadPool(2);
        ExecutorService CachedExecutor = Executors.newCachedThreadPool();
        ExecutorService ScheduledExecutor = Executors.newScheduledThreadPool(2);
        ExecutorService SingleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService ForkJoinPool = Executors.newWorkStealingPool();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5),
                new CustomRejectionPolicy()
        );
        for (int i = 0; i< 20; i++) {
            executor.submit(new MyWorker(i));
        }
    }
}
class MyWorker extends Thread implements Runnable {
    int taskId;
    public MyWorker(int taskId) {
        this.taskId = taskId;
    }
    @Override
    public void run() {
        System.out.println("Task " + taskId + " is running");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + taskId + " is done");
    }
}
