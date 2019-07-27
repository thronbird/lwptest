package com.lwptest.basic.interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 顺序打印abc
 *
 * @author liwanping
 * @since 2019-07-15
 */

public class ThreadAlteV2{
    private int signal =0;

    private Lock lock =  new ReentrantLock();
    private Condition con1 = lock.newCondition();
    private Condition con2 = lock.newCondition();
    private Condition con3 = lock.newCondition();

     void a() throws InterruptedException {
        try{
            lock.lock();
            while(signal !=0){
                con1.await();
            }
            System.out.println("a");
            signal=1;
            con2.signal();
        }finally {
            lock.unlock();
        }
    }
    synchronized void b() throws InterruptedException {
        try{
            lock.lock();
            while(signal !=1){
                con2.await();
            }
            System.out.println("b");
            signal=2;
            con3.signal();
        }finally {
            lock.unlock();
        }
    }
    synchronized void c() throws InterruptedException {
        try{
            lock.lock();
            while(signal !=2){
                con3.await();
            }
            System.out.println("c");
            signal=0;
            con1.signal();
        }finally {
            lock.unlock();
        }
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
