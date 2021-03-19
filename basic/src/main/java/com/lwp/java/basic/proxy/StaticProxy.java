package com.lwp.java.basic.proxy;

public class StaticProxy implements Hello {
    Hello hello;

    public StaticProxy(Hello hello) {
        this.hello = hello;
    }

    @Override
    public void say(){
        before();
        hello.say();
        after();
   }


    void before(){
        System.out.println("before");
    }
    void after(){
        System.out.println("after");
    }
}
