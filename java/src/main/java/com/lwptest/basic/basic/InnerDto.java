package com.lwptest.basic.basic;

import lombok.Data;

/**
 * @author liwanping
 * @since 2019-04-22
 */
@Data
public class InnerDto {
    A a;
    public static void main (String[] args ){
        InnerDto inner = new InnerDto();
        A a1= new A();
        inner.setA(a1);
        a1.setX("sdasd");
        System.out.println(inner.getA().getX());
    }
}
