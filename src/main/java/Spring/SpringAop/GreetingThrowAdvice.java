package Spring.SpringAop;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by lizanle on 2017/4/13.
 */
@Component
public class GreetingThrowAdvice implements ThrowsAdvice {
    // 这个方法 是直接这么写就可以了

    /**
     * 实现以下四个方法之一就可以
     * public void afterThrowing(Exception ex)
     * public void afterThrowing(RemoteException)
     * public void afterThrowing(Method method, Object[] args, Object target, Exception ex)
     * public void afterThrowing(Method method, Object[] args, Object target, ServletException ex)
     * @param method
     * @param args
     * @param target
     * @param e
     */
    public void afterThrowing(Method method, Object[] args, Object target,Exception e){
        System.out.println("----------------Throw Exception-------------------");
        System.out.println("target class:" + target.getClass().getName());
        System.out.println("method name:" + method.getName());
        System.out.println("excetion msg:" + e.getMessage());
        System.out.println("--------------------------------------------------");
    }
}