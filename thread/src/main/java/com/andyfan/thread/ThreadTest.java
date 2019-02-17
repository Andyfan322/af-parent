package com.andyfan.thread;

import java.util.Random;

/**
 * @author andyFan
 * @date 2018年12月02日  11:49:57
 *
 * 演示stop和Interrupted 区别
 */
public class ThreadTest {
    static Integer i, j;

        static Runnable r1 = () -> {

        while (true) {
            if(Thread.currentThread().isInterrupted()) {
                i = new Random().nextInt();
                j = i;
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    };

    static Runnable r2 = () -> {
        while (true) {
            if (i != j) {
                System.out.println("i:" + i + ",j:" + j);
            } else {
                System.out.println("00000");
            }
        }
    };

    public static void main(String[] args) {
        Thread read = new Thread(r2);
        read.start();
        while (true) {
            Thread write = new Thread(r1);
            write.start();
//            try {
//                Thread.sleep(25);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            write.interrupt();
        }
    }
}
