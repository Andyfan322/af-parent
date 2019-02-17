package com.andyfan.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author andyFan
 * @date 2018年12月02日  20:55:57
 */
public class ConditionDemo {
    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();


    static Runnable r = () -> {
        lock.lock();
        try {
            System.out.println("执行condition.await()方法，暂停方法");
            condition.await();
            System.out.println("恢复执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    };

    public static void main(String[] args) {
        Thread t1 = new Thread(r);
        t1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        condition.signal();
        lock.unlock();
        System.out.println("执行condition.signal()方法");

    }
}
