package com.lwptest.basic.Thread;

/**
 * 利用volatile实现自旋锁控制线程执行顺序
 * @author liwanping
 * @since 2019-07-21
 */
public class Spinlock {
    private volatile boolean lock = false;

    public static void main (String[] args ){
        Spinlock spinlock = new Spinlock();
        new Thread(()->{
            for(int i = 0;i<=5;i++){
                System.out.println("线程1："+i);
            }
            spinlock.lock = true;
        }).start();
        new Thread(()->{
            while(!spinlock.lock){
            }
            System.out.println("线程2：start");
        }).start();
    }
}
