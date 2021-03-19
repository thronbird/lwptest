package com.lwp.java.basic.other;

/**
 * @author liwanping
 * @since 2019-07-14
 */
public class StringTest {

    public static void main (String[] args ){
            String a = "hello" + "world";
        String b= "helloworld";
        String temp =  "hello";
        String temp2 = "world";
        String c = temp+temp2;
        System.out.println(a==b);
        System.out.println(a==c);
    }
}
