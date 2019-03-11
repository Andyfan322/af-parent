package com.andyfan.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author andyFan
 * @since 2019年02月20日
 *
 * 可重入锁+Condition来实现
 */
public class PC2 {

    private static Integer count = 0;
    private static final Integer FULL = 10;
    private Lock lock = new ReentrantLock();

    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public static void main(String[] args) {
        PC2 pc2 = new PC2();
        new Thread(pc2.new Producer()).start();
        new Thread(pc2.new Producer()).start();
        new Thread(pc2.new Consumer()).start();
        new Thread(pc2.new Producer()).start();
        new Thread(pc2.new Consumer()).start();
        new Thread(pc2.new Producer()).start();
        new Thread(pc2.new Consumer()).start();
        new Thread(pc2.new Producer()).start();
        new Thread(pc2.new Consumer()).start();

    }

    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    lock.lock();
                    while (count.equals(FULL)) {
                        try {
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前公有：" + count);
                    notEmpty.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }


    class Consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    lock.lock();
                    while (count == 0) {
                        try {
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                    notFull.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }


            }


        }
    }
}
