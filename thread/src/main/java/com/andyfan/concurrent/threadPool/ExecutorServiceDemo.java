package com.andyfan.concurrent.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author andyFan
 * @date 2018年12月10日  19:36:51
 */
public class ExecutorServiceDemo {
    private static ExecutorService service = Executors.newFixedThreadPool(10);
    private static Runnable r = () -> System.out.println("我是 Runnable 线程" + Thread.currentThread().getName());
    private static Callable c = () -> "我是Callable 线程" + Thread.currentThread().getName();
    static CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args) throws Exception {
        List<Callable<String>> callableList = new ArrayList<>();
        countDownLatch.await();
        for (int i = 0; i < 10; i++) {
//            Future<?> future = service.submit(r);
//            Future<?> future2 = service.submit(c);
            callableList.add(c);
            countDownLatch.countDown();
//            System.out.println(future.isDone());
//            System.out.println(future2.get());
        }
        List<Future<String>> futures = service.invokeAll(callableList);
        for (int i = 0; i < 10; i++) {
            System.out.println(futures.get(i).isDone());
        }
        service.shutdown();
    }
}
