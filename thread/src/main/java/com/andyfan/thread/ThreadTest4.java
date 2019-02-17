package com.andyfan.thread;

/**
 * @author andyFan
 * @date 2018年12月02日  16:00:38
 * 演示join和yield（ 谦让）
 */
public class ThreadTest4 {
    static int j = 0;

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                j = i;
            }
        });
        thread.start();
        thread.join();//main的输出，等待线程执行完再执行
        System.out.println(j);
    }
}
