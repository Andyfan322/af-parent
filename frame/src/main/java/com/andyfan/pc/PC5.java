package com.andyfan.pc;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author andyFan
 * @since 2019年02月20日
 * <p>
 * 管道流实现
 */
public class PC5 {
    private final PipedInputStream pis = new PipedInputStream();
    private final PipedOutputStream pos = new PipedOutputStream();

    {
        try {
            pis.connect(pos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        PC5 pc5 = new PC5();
        new Thread(pc5.new Producer()).start();
        new Thread(pc5.new Consumer()).start();
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                    int num = (int) (Math.random() * 255);
                    System.out.println(Thread.currentThread().getName() + "生产者产生了一个数字，该数字为：" + num);
                    pos.write(num);
                    pos.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        pos.close();
                        pis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(300);
                    int num = pis.read();
                    System.out.println("消费者消费了一个数字，该数字为：" + num);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        pos.close();
                        pis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
