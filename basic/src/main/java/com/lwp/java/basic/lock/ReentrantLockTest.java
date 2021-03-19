package com.lwp.java.basic.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liwanping
 * @since 2019-07-12
 */
public class ReentrantLockTest {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main (String[] args ) throws InterruptedException {
        lock.tryLock(4, TimeUnit.DAYS);
    }
}
