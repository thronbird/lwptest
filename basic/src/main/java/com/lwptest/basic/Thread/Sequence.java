package com.lwptest.basic.Thread;

/**
 * @author liwanping
 * @since 2019-07-20
 */
public class Sequence {
    private int value;

    private synchronized void getNext() {
        value++;
        System.out.println(Thread.currentThread().getName() +"::"+value);
    }

    public static void main(String[] args) {
        Sequence s = new Sequence();
        new Thread(() -> {
            while(true){
                s.getNext();
            }
        }).start();
        new Thread(() -> {
            while(true){
                s.getNext();
            }
        }).start();
        new Thread(() -> {
            while(true){
                s.getNext();
            }
        }).start();
    }

}
