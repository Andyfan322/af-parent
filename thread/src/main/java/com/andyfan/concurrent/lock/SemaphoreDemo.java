package com.andyfan.concurrent.lock;

import java.util.concurrent.Semaphore;

/**
 * @author andyFan
 * @date 2018年12月07日  21:24:37
 */
public class SemaphoreDemo {
    static Semaphore semaphore = new Semaphore(3,true);
    static Runnable r = () -> {
        try {
            System.out.println(Thread.currentThread().getName() + "等待");
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+"进入");
            semaphore.release();
            System.out.println(Thread.currentThread().getName() + "释放");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    public static void main(String[] args) {
        Thread t1 = new Thread(r,"1");
        Thread t2 = new Thread(r,"2");
        Thread t3 = new Thread(r,"3");
        t1.start();
        t2.start();
        t3.start();
    }
}
