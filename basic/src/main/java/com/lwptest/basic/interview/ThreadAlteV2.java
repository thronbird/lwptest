package com.lwptest.basic.interview;

/**
 * 顺序打印abc
 *
 * @author liwanping
 * @since 2019-07-15
 */

public class ThreadAlteV2{
    private int signal =0;

    synchronized void a() throws InterruptedException {
        while(signal !=0){
            wait();
        }
        System.out.println("a");
        signal=1;
        notifyAll();
    }
    synchronized void b() throws InterruptedException {
        while(signal !=1){
            wait();
        }
        System.out.println("b");
        signal=2;
        notifyAll();
    }
    synchronized void c() throws InterruptedException {
        while(signal !=2){
            wait();
        }
        System.out.println("c");
        signal=0;
        notifyAll();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadAlteV2 v = new ThreadAlteV2();
        A a = new A(v);
        B b = new B(v);
        C c = new C(v);
        Thread thread1 = new Thread(a);
        Thread thread2 = new Thread(b);
        Thread thread3 = new Thread(c);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class A implements Runnable{
    ThreadAlteV2 v;
    A(ThreadAlteV2 v){
        this.v=v;
    }
    public void run(){
       while(true){

           try {v.a();
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}
class B implements Runnable{
    ThreadAlteV2 v;
    B(ThreadAlteV2 v){
        this.v=v;
    }
    public void run(){
        while(true){

            try { v.b();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class C implements Runnable{
    ThreadAlteV2 v;
    C(ThreadAlteV2 v){
        this.v=v;
    }
    public void run(){
        while(true){
            try {
                v.c();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
