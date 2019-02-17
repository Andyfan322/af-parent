package com.andyfan.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author andyFan
 * @date 2018年12月02日  19:48:51
 * 中断
 */
public class ReentryLockTest2 {
    static ReentrantLock lock = new ReentrantLock();//小明
    static ReentrantLock lock2 = new ReentrantLock();//小刚
    static boolean isInterrupt = false;
    static String friend ;

    private static void setInterrupt(boolean isInterrupt,String friend) {
        ReentryLockTest2.isInterrupt = isInterrupt;
        ReentryLockTest2.friend = friend;
    }

    public static void main(String[] args) {
        Runnable r = () -> {
            if (isInterrupt) {
                try {
                    lock.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + "突然有急事，如是打电话给"+friend+"，今天有事，不能去打篮球了");
                    lock2.lockInterruptibly();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if(lock.isHeldByCurrentThread())lock.unlock();
                    if(lock2.isHeldByCurrentThread())lock2.unlock();
                }
            }
        };
        Thread t1 = new Thread(r);
        t1.setName("小明");
        setInterrupt(true,"小刚");
        Thread t2 = new Thread(r);
        t2.setName("小刚");
        setInterrupt(true,"小明");
        t1.start();
        t2.start();
    }
}
