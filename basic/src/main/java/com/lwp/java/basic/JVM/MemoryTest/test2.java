package com.lwp.java.basic.JVM.MemoryTest;

/**
 * @author liwanping
 * @date 2019-03-03
 */
public class test2 {
    public static int calculateNeedWeight(Integer weight,Integer height,Integer targetBMI){
        Double targetWeight = new Double(targetBMI)*new Double(height)*new Double(height)/10000;
        return (int)(Math.ceil(new Double(weight)-targetWeight));

    }

    public static void main (String[] args ){
        System.out.println(calculateNeedWeight(90,180,23));
    }
}
