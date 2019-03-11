package com.andyfan.pc;

import java.util.concurrent.Semaphore;

/**
 * @author andyFan
 * @since 2019年02月20日
 * <p>
 * 信号量实现
 */
public class PC4 {

    private static Integer count = 0;
    private final Semaphore notFull = new Semaphore(0);
    private final Semaphore notEmpty = new Semaphore(0);
    private final Semaphore mutex = new Semaphore(1);

    class Producer implements Runnable {
        @Override
        public void run() {
            PC4 pc4 = new PC4();
            new Thread(pc4.new Producer()).start();
            new Thread(pc4.new Consumer()).start();
            new Thread(pc4.new Producer()).start();
            new Thread(pc4.new Consumer()).start();
            new Thread(pc4.new Producer()).start();
            new Thread(pc4.new Consumer()).start();
            new Thread(pc4.new Producer()).start();
            new Thread(pc4.new Consumer()).start();

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    notFull.acquire();
                    mutex.acquire();
                    count++;
                    System.out.println(Thread.currentThread().getName()
                            + "生产者生产，目前总共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mutex.release();
                    notFull.release();
                }
            }


        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                try {
                    notEmpty.acquire();
                    mutex.acquire();
                    count--;
                    System.out.println(Thread.currentThread().getName()
                            + "消费者消费，目前总共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mutex.release();
                    notFull.release();
                }
            }
        }
    }


}
