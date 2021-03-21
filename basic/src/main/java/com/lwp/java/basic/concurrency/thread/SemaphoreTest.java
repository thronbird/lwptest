package com.lwp.java.basic.concurrency.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author liwanping
 * @date 2018-08-10
 */
public class SemaphoreTest {
    private static final Logger logger = LoggerFactory.getLogger(SemaphoreTest.class);

    private static final Integer maxSingleProcessCount = 100;

    private static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

    public static void main(String[] args) {

        final Semaphore semaphore = new Semaphore(maxSingleProcessCount);

        while (executor.getActiveCount() < 5) {
            executor.submit(new Runnable() {
                                @Override
                                public void run() {
                                    while (true) {
                                        try {
                                            semaphore.acquire(1);
                                        } catch (InterruptedException e) {
                                            logger.debug("process done");
                                            return;
                                        }
                                        System.out.println(Thread.currentThread().getName()+ " acquire 1 permit");
                                    }
                                }
                            }
            );
        }
    }
}
