package com.lwp.java.basic.thread;

/**
 * @author liwanping
 * @date 2018-10-09
 */
public class ThreadLocalTest {
    private ThreadLocal<String> local = new ThreadLocal<String>();

    void test(){
        local.set("ss");
        local.set("dd");
        System.out.println(local.get());
    }

    public static void main (String[] args ){
       new ThreadLocalTest().test();
    }

}
