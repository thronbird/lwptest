package SpringAop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 *  同时实现前置增强 和 后置增强
 * Created by lizanle on 2017/4/13.
 */
@Component
public class GreetingBeforeAndAdvice implements MethodBeforeAdvice,AfterReturningAdvice{

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("before");
    }
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("after");
    }



}
