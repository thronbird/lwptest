package com.lwptest.basic.interview;

/**
 * @author liwanping
 * @since 2019-07-14
 */
public class Test implements Runnable {
    int b = 100;

    synchronized void m1() throws InterruptedException {
        b = 1000;
        Thread.sleep(500);
        System.out.println("b=" + b);
    }

    synchronized void m2() throws InterruptedException {
        Thread.sleep(250);
        b = 2000;
    }

    public static void main(String[] args) throws InterruptedException {
        Test tt = new Test();
        Thread t = new Thread(tt);
        t.start();
        tt.m2();
        System.out.println("mainb=" + tt.b);
    }

    @Override
    public void run() {
        try {
            m1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


