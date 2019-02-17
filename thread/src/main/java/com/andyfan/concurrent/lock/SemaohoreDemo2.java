package com.andyfan.concurrent.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author andyFan
 * @date 2018年12月08日  13:41:43
 */
public class SemaohoreDemo2 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3, true);
        for (int i = 0; i < 6; i++) {
            Runnable runnable = () -> {
                try {
                    semaphore.acquire();//获取信号灯许可
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(2000);//为了打印，进入临界区总的线程数量
                    System.out.println(Thread.currentThread().getName()+"进入临界区");
                    Thread.sleep(4000);//模拟业务逻辑处理
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+"释放信号");
                semaphore.release();//释放信号灯

            };
            pool.execute(runnable);

        }
        pool.shutdown();
    }
}
