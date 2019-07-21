package com.lwptest.basic.interview;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * alibaba面试题：创建三个线程交替打印 每个线程打印5个数字 递增到75
 * @author liwanping
 * @since 2019-07-15
 */

public class AliInterview implements Runnable {
        private AtomicInteger x = new AtomicInteger(1);
        private ReentrantLock lock = new ReentrantLock(true);
        private Semaphore sea = new Semaphore(75);

        public static void main(String[] args) throws InterruptedException {
            new AliInterview().test();
        }

        public void test() throws InterruptedException {
            AliInterview test = new AliInterview();
            Thread thread1 = new Thread(test);
            Thread thread2 = new Thread(test);
            Thread thread3 = new Thread(test);
            thread1.start();
            thread2.start();
            thread3.start();
        }

        public void run() {
                while(true){
                    try{
                        lock.lock();
                        sea.acquire(5);
                        for (int i = 0; i < 5; i++) {
                            System.out.println(Thread.currentThread().getName() + ":" + x);
                            x.getAndIncrement();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally{
                    lock.unlock();
                }
            }
    }
}
