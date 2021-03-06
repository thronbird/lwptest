package com.lwp.java.basic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler{
    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    void before(){
        System.out.println("before");
    }
    void after(){
        System.out.println("after");
    }
    public <A> A  getproxy(){
       return (A)Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result= method.invoke(target,args);
        after();
        return result;
    }
}
