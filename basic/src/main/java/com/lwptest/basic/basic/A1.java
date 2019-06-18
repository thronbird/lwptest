package com.lwptest.basic.basic;

/**
 * @author liwanping
 * @date 2019-04-12
 */
public class A1 extends A{
    A1(){
        x="3";
    }
    String x;

     void test(){
         new A().out();
    }
    public static void main (String[] args ){
        new A1().test();
    }
}
