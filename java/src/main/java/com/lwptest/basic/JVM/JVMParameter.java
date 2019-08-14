package com.lwptest.basic.JVM;

/**
 * Created by liwanping on 2018-04-07
 */
public class JVMParameter {

    /**
     * 运行前设置JVM参数 -Djvm.index=1
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String jvmIndex = System.getProperty("jvm.index");
        System.out.println("jvmIndex=" + jvmIndex);
    }
}