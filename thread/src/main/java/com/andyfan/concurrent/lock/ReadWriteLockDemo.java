package com.andyfan.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author andyFan
 * @date 2018年12月08日  16:07:22
 * 读写锁
 */
public class ReadWriteLockDemo {

    final static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    final static Lock readLock = readWriteLock.readLock();
    final static Lock writeLock = readWriteLock.writeLock();

    public void read(Lock lock) throws Exception {
        Thread read = new Thread(() -> {
            lock.lock();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        read.start();
    }

    public void write(Lock lock) throws Exception {
        Thread write = new Thread(() -> {
            lock.lock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        write.start();
    }

    public static void main(String[] args) throws Exception {
        ReadWriteLockDemo demo = new ReadWriteLockDemo();
        for (int i = 0; i < 10; i++) {
            demo.read(readLock);
            demo.write(writeLock);

        }
    }
}
