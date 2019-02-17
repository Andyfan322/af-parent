package com.andyfan.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author andyFan
 * @date 2018年12月02日  20:17:27
 * 公平锁
 */
public class ReentryLockTest4 {
    static ReentrantLock fairLock = new ReentrantLock(true);

    static Runnable enteringCinema = () -> {
        try {
            fairLock.lock();
            System.out.println(Thread.currentThread().getName() + "进场");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fairLock.isHeldByCurrentThread()) fairLock.unlock();
        }
    };

    public static void main(String[] args) {
        Thread t1 = new Thread(enteringCinema, "路人甲");
        Thread t2 = new Thread(enteringCinema, "小明");
        Thread t3 = new Thread(enteringCinema, "小明女朋友");
        Thread t4 = new Thread(enteringCinema, "路人乙");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
