package com.andyfan.concurrent.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author andyFan
 * @date 2018年12月08日  17:53:07
 * 倒计时器
 */
public class CountDownLatchDemo {
    static CountDownLatch countDownLatch = new CountDownLatch(5);
    static ReentrantLock lock = new ReentrantLock();
    static AtomicInteger count = new AtomicInteger(1);

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newCachedThreadPool();
        Thread t = new Thread(() -> {
            try {
                lock.lock();
                Thread.sleep(100);
                System.out.println("火箭发射前设备状态检查" + count.getAndIncrement());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            countDownLatch.countDown();
        });
        for (int i = 0; i < 5; i++) {
            service.execute(t);
        }
        countDownLatch.await();
        System.out.println("设备状态检查执行完了，开始发射！");
    }


}
