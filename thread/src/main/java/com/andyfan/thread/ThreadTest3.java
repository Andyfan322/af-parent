package com.andyfan.thread;

/**
 * @author andyFan
 * @date 2018年12月02日  15:31:19
 */
public class ThreadTest3 {
    final static Object object = new Object();

    static Runnable r = () -> {
        synchronized (object) {
            String name = Thread.currentThread().getName();
            System.out.println(name);
            Thread.currentThread().suspend();
            System.out.println(name + "被刮挂起后执行。。。");
        }
    };

    public static void main(String[] args) {
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.resume();
        t2.resume();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
