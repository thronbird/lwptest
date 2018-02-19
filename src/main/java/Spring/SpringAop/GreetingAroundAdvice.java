package Spring.SpringAop;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreetingAroundAdvice implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        before();
        Object result=invocation.proceed();
        afterReturning();
        return result;
    }
    public void before() {
        System.out.println("before");
    }
    public void afterReturning() {
        System.out.println("after");
    }
}
