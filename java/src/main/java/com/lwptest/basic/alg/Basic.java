package com.lwptest.basic.alg;

import org.junit.Test;

/**
 * @author liwanping
 * @since 2019-07-08
 */
public class Basic {
    @Test
    public void test1(){
        System.out.println(4>>3);
    }

    @Test
    public void test2(){
        Integer a = 2;
        Integer b = 2;
        System.out.println(a==b);
    }

    @Test
    public void test3(){
        int a=0;
        new Thread(new Runnable() {
            @Override
            public void run() {
               // a++;
            }
        }).start();
    }
}
