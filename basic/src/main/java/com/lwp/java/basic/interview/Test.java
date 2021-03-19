package com.lwp.java.basic.interview;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author liwanping
 * @since 2019-07-27
 */
public class Test {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        Executors.newCachedThreadPool();
        Semaphore se = new Semaphore(10);
        CountDownLatch countDownLatch = new CountDownLatch(10);

        CyclicBarrier c = new CyclicBarrier(10,()->{
            System.out.println("ccc");
        });
        for(int i=0;i<=10;i++){
            new Thread(() -> {
                System.out.println("ddd");
                try {
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(6000);
    }
}
