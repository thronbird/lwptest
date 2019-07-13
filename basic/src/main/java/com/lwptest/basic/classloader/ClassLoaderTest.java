package com.lwptest.basic.classloader;

/**
 * @author liwanping
 * @since 2019-06-18
 */
public class ClassLoaderTest {
    public static void main(String[] args)  {
        A.class.getClassLoader();
        new A();
        try {
            System.out.println(ClassLoaderTest.class.getClassLoader().loadClass("com.lwptest.basic.classloader.A"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getContextClassLoader());
        //new String().echo();
    }
}

