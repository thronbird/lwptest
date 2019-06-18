package com.lwptest.basic.Proxy;

import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        cglibtest();
    }

    static void statictest() {
        new StaticProxy(new HelloImpl()).say();
    }

    static void dynamictest() {
        Hello hello = new HelloImpl();
        DynamicProxy dynamicProxy = new DynamicProxy(hello);
        Hello helloproxy = (Hello) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), dynamicProxy);
        helloproxy.say();
    }

    static void dynamictest2() {
        Hello hello = new HelloImpl();
        DynamicProxy dynamicProxy = new DynamicProxy(hello);
        Hello helloproxy = dynamicProxy.getproxy();
        helloproxy.say();
    }

    static void cglibtest() {
        Hello hello = new HelloImpl();
        Hello cgProxy = CGLibProxy.getInstance().getproxy(hello.getClass());
        cgProxy.say();
    }
}
