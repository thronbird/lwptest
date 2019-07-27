package com.lwptest.basic.interview.thread.commu;

import javax.annotation.security.RunAs;

/**
 * Producer and Consumer test
 *
 * @author liwanping
 * @since 2019-07-27
 */
public class PCTest {
    public static void main(String[] args) throws InterruptedException {
        Clerk cl = new Clerk();
        new Thread(new Producer(cl), "producer1").start();
        new Thread(new Producer(cl), "producer2").start();
        new Thread(new Producer(cl), "producer3").start();
        new Thread(new Consumer(cl), "consumer1").start();
    }
}

class Clerk {
    private int max = 10;
    private int count = 0;

    synchronized void produce() throws InterruptedException {
        while (count >= 10) {//放在while循环中防止虚假唤醒
            wait();
           // System.out.println(Thread.currentThread().getName() + "超出限制");
        }
        System.out.println(Thread.currentThread().getName() + "开始生产：" + ++count);
        notifyAll();
    }

    synchronized void consume() throws InterruptedException {
        while (count <= 0) {
            wait();
          //  System.out.println(Thread.currentThread().getName() + "超出限制");
        }
        System.out.println(Thread.currentThread().getName() + "开始消费：" + --count);
        notifyAll();
    }
}

class Producer implements Runnable {
    Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    public void run() {
        while (true) {
            try {
                clerk.produce();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    public void run() {
        while (true) {
            try {
                clerk.consume();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}