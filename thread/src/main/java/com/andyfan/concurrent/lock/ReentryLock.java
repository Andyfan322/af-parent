package com.andyfan.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author andyFan
 * @date 2018年12月02日  16:48:34
 */
public class ReentryLock {
    static int sum = 0;

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Runnable r = () -> {
            for (int i = 0; i < 100; i++) {
                reentrantLock.lock();
                sum++;
                reentrantLock.unlock();
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sum);

    }


//     ReentrantLock reentrantLock = new ReentrantLock();
//     static int i = 0;
//
//
//    @Override
//    public void run() {
//        reentrantLock.lock();
//        for (int j = 0; j < 100; j++) {
//            i++;
//        }
//        reentrantLock.unlock();
//    }
//
//    public static void main(String[] args) {
//        ReentrLock r=new ReentrLock();
//        Thread t1=new Thread(r);
//        Thread t2=new Thread(r);
//        t1.start();
//        t2.start();
//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(i);
//    }
}
