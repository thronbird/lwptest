package com.lwp.java.basic.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class MultithreadedDebuggerTest {

   private final ReadWriteLock lock = new ReentrantReadWriteLock();

    @Test
    public void test() throws Exception {
        ExecutorService svc = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 3; i++) {
            svc.submit(new Runnable() {
                @Override
                public void run() {
                    //if (l.isDebugEnabled()) log.debug("Running");
                    int i = 0;
                    i++;
                    //long-running method
                    //long prime = findPrime(1000);
                    //log.info(prime);
                   // lock.readLock().lock();
                    int j;
                    try {
                        j = i + 1;
                    } finally {
                        lock.readLock().unlock();
                    }
                    //if (log.isDebugEnabled()) log.debug("Finished " + j);
                }

            });
        }

        Thread.sleep(10000);
        svc.shutdown();
        svc.awaitTermination(5, TimeUnit.SECONDS);
    }
}
