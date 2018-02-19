package Spring.SpringAop;

import org.springframework.aop.framework.ProxyFactory;

/**
 *  客户端
 * Created by lizanle on 2017/4/13.
 */
public class Client {
    public static  void main(String[] args){
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
      // proxyFactory.addAdvice(new GreetingBeforeAdvice());
     //  proxyFactory.addAdvice(new GreetingAfterAdvice());
       //proxyFactory.addAdvice(new GreetingBeforeAndAdvice());
        proxyFactory.addAdvice(new GreetingAroundAdvice());
        proxyFactory.addAdvice(new GreetingAroundAdvice());
        proxyFactory.addAdvice(new GreetingThrowAdvice());
        Greeting proxy = (Greeting)proxyFactory.getProxy();
        proxy.sayHello("zzz");
    }
}
