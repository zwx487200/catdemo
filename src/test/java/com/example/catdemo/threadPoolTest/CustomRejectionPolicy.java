package com.example.catdemo.threadPoolTest;

import java.util.concurrent.*;

public class CustomRejectionPolicy implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        // 如果被拒绝，在开一个线程去处理
        System.out.println("Task " + r+ " is rejected");
        ThreadPoolExecutor executor1 = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5),
                new CustomRejectionPolicy()
        );
        System.out.println("被拒绝的线程有重新执行了" + r.toString());
        executor1.submit(new MyWorker2(r));

    }
}
class MyWorker2 extends Thread implements Runnable {
    Runnable run;
    public MyWorker2(Runnable run) {
        this.run = run;
    }
    @Override
    public void run() {
        System.out.println("Task " + run + " is  重新执行 running");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + run + " is  重新执行 done");
    }
}
