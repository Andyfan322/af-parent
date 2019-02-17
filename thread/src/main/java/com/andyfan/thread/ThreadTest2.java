package com.andyfan.thread;

/**
 * @author andyFan
 * @date 2018年12月02日  14:41:40
 * 演示 wait和notify
 */
public class ThreadTest2 {
    final static Object object = new Object();

    static Runnable r1 = () -> {
        synchronized (object) {
            long start = 0l;
            try {
                System.out.println("wait方法被执行了");
                start = System.currentTimeMillis();
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
            System.out.println("wait方法释放后被执行了,等待了notify方法释放锁" + (System.currentTimeMillis() - start)/1000  + "秒");
        }
    };

    static Runnable r2 = () -> {
        synchronized (object) {
            object.notify();
            System.out.println("notify方法被执行了");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("notify休眠1秒后");
        }
    };

    public static void main(String[] args) {
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
