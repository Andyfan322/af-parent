package com.andyfan.pc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author andyFan
 * @since 2019年02月20日
 * <p>
 * 阻塞队列实现
 */
public class PC3 {
    private static Integer count = 0;
    private final BlockingQueue blockingDeque = new ArrayBlockingQueue(10);

    public static void main(String[] args) {
        PC3 pc3 = new PC3();
        new Thread(pc3.new Producer()).start();
        new Thread(pc3.new Consumer()).start();
        new Thread(pc3.new Producer()).start();
        new Thread(pc3.new Consumer()).start();
        new Thread(pc3.new Producer()).start();
        new Thread(pc3.new Consumer()).start();
        new Thread(pc3.new Producer()).start();
        new Thread(pc3.new Consumer()).start();

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
                    blockingDeque.put(1);
                    count++;
                    System.out.println(Thread.currentThread().getName()
                            + "生产者生产，目前总共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
                    blockingDeque.take();
                    count--;
                    System.out.println(Thread.currentThread().getName()
                            + "消费者消费，目前总共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
