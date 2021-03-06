package com.lwp.java.basic.BigDecimal;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by geely
 */




public class BigDecimalTest {

    @Test
    public void test1(){
        System.out.println(0.05+0.01);
        System.out.println(1.0-0.42);
        System.out.println(4.015*100);
        System.out.println(123.3/100);
    }







    @Test
    public void test2(){
        BigDecimal b1 = new BigDecimal(0.05);
        BigDecimal b2 = new BigDecimal(0.01);
        System.out.println(b1.add(b2));
    }

    @Test
    public void test3(){
        BigDecimal b1 = new BigDecimal("-0.05");
        BigDecimal b2 = new BigDecimal("0.01");
        System.out.println(b1.add(b2));
        System.out.println(b1.compareTo(BigDecimal.ZERO));

    }

    @Test
    public void test4(){
        System.out.println(new BigDecimal("1.1").multiply(new BigDecimal("1000")).toBigInteger());
        System.out.println(new BigDecimal("1.1").multiply(new BigDecimal("1000")).setScale(0).toString());
    }
}
