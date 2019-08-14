package com.lwptest.basic.Proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibProxy implements MethodInterceptor {

    private static CGLibProxy p = new CGLibProxy();

    private CGLibProxy() {

    }

    //singleton
    public static CGLibProxy getInstance() {
        return p;
    }

    private Object target;

    void before() {
        System.out.println("before");
    }

    void after() {
        System.out.println("after");
    }

    public <T> T getproxy(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(obj, args);
        after();
        return result;
    }
}
