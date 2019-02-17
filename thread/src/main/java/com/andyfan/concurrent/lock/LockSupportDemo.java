package com.andyfan.concurrent.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author andyFan
 * @date 2018年12月09日  12:56:55
 * 线程阻塞
 */
public class LockSupportDemo {
    static Runnable r = () -> {
        try {
            Thread.sleep(10);
            System.out.println(Thread.currentThread().getName() + "执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.park();
    };

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(r, "1");
        Thread t2 = new Thread(r, "2");
        t1.start();
        t2.start();
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }
}
