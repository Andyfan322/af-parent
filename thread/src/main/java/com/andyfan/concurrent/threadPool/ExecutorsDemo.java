package com.andyfan.concurrent.threadPool;

import java.util.concurrent.*;

/**
 * @author andyFan
 * @date 2018年12月11日  14:00:02
 * 线程池工厂
 */
public class ExecutorsDemo {

    private static ExecutorService service = Executors.newCachedThreadPool();
    private static ExecutorService service2 = Executors.newFixedThreadPool(3);
    private static ScheduledExecutorService service3 = Executors.newScheduledThreadPool(3);
    private static ExecutorService service4 = Executors.newSingleThreadExecutor();
    private static ExecutorService service5 = Executors.newWorkStealingPool();

    public static void main(String[] args) throws Exception {
        addTask("newCachedThreadPool", service);
        addTask("newFixedThreadPool", service2);
        addTask("newScheduledThreadPool", service3);
        addTask("newSingleThreadExecutor", service4);
        addTask("newWorkStealingPool", service5);
    }

    private static void addTask(String type, ExecutorService service) throws Exception {
        for (int i = 0; i < 10; i++) {
            service.execute(() -> System.out.println(type + "," + Thread.currentThread().getName()));
        }
        service.shutdown();
        service.awaitTermination(5, TimeUnit.MILLISECONDS);//等待任务完成再关闭主main线程
    }
}
