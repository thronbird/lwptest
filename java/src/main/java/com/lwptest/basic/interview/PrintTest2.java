package com.lwptest.basic.interview;

import java.util.concurrent.Semaphore;

/**
 * @author liwanping
 * @since 2019-07-27
 */
public class PrintTest2 {
    public static void main(String[] args) {
        ShareSemaphoreABC s = new ShareSemaphoreABC();
        new Thread(()-> {
            try {
                while (true){
                    s.printA();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                while (true){
                    s.printB();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                while (true){
                    s.printC();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class ShareSemaphoreABC{
    private Semaphore a = new Semaphore(1);
    private Semaphore b = new Semaphore(0);
    private Semaphore c = new Semaphore(0);

    void printA() throws InterruptedException {
        print("A",a,b);
    }
    void printB() throws InterruptedException {
        print("B",b,c);
    }
     void printC() throws InterruptedException {
        print("C",c,a);
    }

    private void print(String a, Semaphore s,Semaphore ns) throws InterruptedException {
        s.acquire();
        ns.release();
        System.out.println(a);
    }
}
