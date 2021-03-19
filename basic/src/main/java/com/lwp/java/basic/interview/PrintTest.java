package com.lwp.java.basic.interview;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author liwanping
 * @since 2019-07-27
 */
public class PrintTest {
        static final BlockingQueue<Thread> bq = new ArrayBlockingQueue<>(3);
        public static void main(String[] args) throws InterruptedException {
            Runnable a = new Runnable() {
                @Override
                public void run() {
                    System.out.print("-" + Thread.currentThread().getName());
                }
            };
            bq.add(new Thread(a, "A"));
            bq.add(new Thread(a, "B"));
            bq.add(new Thread(a, "C"));
            for (int i = 0; i < 10; i++) {
                Thread t = null;
                while (!bq.isEmpty()) {
                    t = bq.take();
                    t.start();
                    TimeUnit.MILLISECONDS.sleep(1);
                }
                bq.add(new Thread(a, "A"));
                bq.add(new Thread(a, "B"));
                bq.add(new Thread(a, "C"));
            }
        }
}
