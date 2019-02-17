package com.andyfan.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author andyFan
 * @date 2018年12月02日  20:17:27
 */
public class ReentryLockTest3 {
    static ReentrantLock lock = new ReentrantLock();//小明
    static ReentrantLock lock2 = new ReentrantLock();//小刚
    static int time = 0;
    static String friend;

    private static void setInterrupt(int time, String friend) {
        ReentryLockTest3.time = time;
        ReentryLockTest3.friend = friend;
    }

    public static void main(String[] args) {
        Runnable r = () -> {
            try {
                if (lock.tryLock(time, TimeUnit.HOURS)) {
                    System.out.println(Thread.currentThread().getName() + "等" + friend + "一起去打篮球");
                } else {
                    lock.lockInterruptibly();
                    lock2.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + "打电话给" + friend + "说，等你太久了，今天不去打篮球了");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock.isHeldByCurrentThread()) lock.unlock();
                if (lock2.isHeldByCurrentThread()) lock2.unlock();
            }
        };
        Thread t1 = new Thread(r, "小明");
        setInterrupt(5, "小刚");
        t1.start();
        Thread t2 = new Thread(r, "小明");
        setInterrupt(0, "小刚");
        t2.start();
    }
}
