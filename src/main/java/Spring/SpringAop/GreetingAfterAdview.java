package Spring.SpringAop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * 后置
 * Created by Administrator on 2017/3/26.
 */
public class GreetingAfterAdview  implements AfterReturningAdvice{
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {

    }
}
