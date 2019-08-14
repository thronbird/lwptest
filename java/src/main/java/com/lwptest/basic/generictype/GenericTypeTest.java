package com.lwptest.basic.generictype;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericTypeTest<A> {
    public List<A> list = new ArrayList<A>();

    public static void main(String[] args) {
        GenericTypeTest<String> test = new GenericTypeTest<String>();
        test.list.add("Hello");
        Arrays.asList("2","33");
        System.out.println(test.list);

        //The  error  message  complains,  in  cryptic  terms  that  vary  from  one compiler
//        version to another, that there are two ways of interpreting this code, both equally
//        valid. In a nutshell, the compiler autoboxed the parameters into a  Double  and two
//        Integer  objects, and then it tried to find a common supertype of these classes. It
//        actually  found  two:  Number   and  the  Comparable   interface,  which  is  itself  a generic
//        type. In this case, the remedy is to write all parameters as  double  values.
        Number middle = getMiddle(3.14, 1729, 0);
    }
    public static <T extends Comparable  & Serializable> T min(T[] a) //��������ʵ����comparable��Serializable�ķ�����ķ���
    {
        if (a == null || a.length == 0) return null;
        T smallest = a[0];
        for (int i = 1; i < a.length; i++)
            if (smallest.compareTo(a[i]) > 0) smallest = a[i];
        return smallest;
    }
    public static <T> T getMiddle(T... a)
    {
        return a[a.length / 2];
    }
}
