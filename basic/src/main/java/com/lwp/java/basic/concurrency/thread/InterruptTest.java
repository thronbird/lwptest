package com.lwp.java.basic.concurrency.thread;

import java.util.List;

/**
 * @author liwanping
 * @date 2018-09-03
 */
public class InterruptTest {

    public static void main(String[] args) throws InterruptedException {
        A t = new A();
        t.start();
        System.out.println(Thread.currentThread().getName()+"--main+be");
        Thread.currentThread().sleep(2000);
        System.out.println(t.getName()+"--main");
        System.out.println(Thread.currentThread().getName()+"--main");
        t.interrupt();

    }

    private static class A extends Thread {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.currentThread().sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("exit");
            List<String>[] x = null;
            x[1].isEmpty();
        }

        public void cancel() {
            interrupt();
        }
    }
}
