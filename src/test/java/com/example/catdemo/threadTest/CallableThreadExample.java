package com.example.catdemo.threadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableThreadExample {
    public static void main(String[] args) {
        // 创建Callable任务
        MyCallableTask task = new MyCallableTask();
        // 将Callable包装进FutureTask
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        // 使用FutureTask创建Thread
        Thread thread = new Thread(futureTask);
        // 启动线程
        thread.start();
        try {
            Integer result = futureTask.get(); // 这会阻塞直到Callable任务完成
            System.out.println("Callable任务返回的结果: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class MyCallableTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        // 模拟耗时操作
        Thread.sleep(1000); // 休眠1秒
        return 123; // 假设这是我们的计算结果
    }
}

