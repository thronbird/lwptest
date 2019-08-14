package com.lwptest.basic.alg;

import java.util.Objects;

/**
 * @author liwanping
 * @since 2019-07-17
 */
public class EqualsAndHashCodeTest {
    private String x;

    public EqualsAndHashCodeTest(String x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EqualsAndHashCodeTest that = (EqualsAndHashCodeTest) o;
        return Objects.equals(x, that.x);
    }

    @Override
    public int hashCode() {

        return Objects.hash(x);
    }

    public static void main (String[] args ){
        EqualsAndHashCodeTest a = new EqualsAndHashCodeTest("dsds");
        EqualsAndHashCodeTest b = new EqualsAndHashCodeTest("tttt");
        System.out.println(a==b);
    }
}
