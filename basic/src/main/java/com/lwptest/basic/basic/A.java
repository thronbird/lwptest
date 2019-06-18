package com.lwptest.basic.basic;

import lombok.Data;

/**
 * @author liwanping
 * @date 2019-04-12
 */
@Data
public class A {
    A(){
        x="2";
    }
    String x;

    void out(){
        System.out.println(x);
        throw new NullPointerException();
    }

    public static void main (String[] args ){
        assert "222".equals("2221");
        assert "222".equals("22") : "dasdsa";
    }
}
