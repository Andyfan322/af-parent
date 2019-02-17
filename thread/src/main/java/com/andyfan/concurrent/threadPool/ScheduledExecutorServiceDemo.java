package com.andyfan.concurrent.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author andyFan
 * @date 2018年12月12日  17:20:27
 */
public class ScheduledExecutorServiceDemo {
    static ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

    public static void main(String[] args) throws Exception {
        //固定频率执行
//        service.scheduleAtFixedRate(() -> System.out.println(Thread.currentThread().getName()), 10, 3, TimeUnit.MILLISECONDS);
//        //间隔时间执行
//        service.scheduleWithFixedDelay(() -> System.out.println(Thread.currentThread().getName()), 10, 3, TimeUnit.MILLISECONDS);
//        service.schedule(() -> System.out.println(Thread.currentThread().getName()), 10, TimeUnit.MILLISECONDS);
        ScheduledFuture<String> future = service.schedule(() -> {
            Thread.sleep(11100); return "你好 ";
        }, 10, TimeUnit.MILLISECONDS);
        System.out.println(future.get()+" 吗？");
    }
}
