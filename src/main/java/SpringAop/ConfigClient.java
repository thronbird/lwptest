package SpringAop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lizanle on 2017/4/13.
 */
public class ConfigClient {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext co = new ClassPathXmlApplicationContext("spring.xml");
        //greetingProxy
        //Greeting greetingProxy = (Greeting)co.getBean("exceptionGreetingProxy");
        Greeting greetingProxy = (Greeting)co.getBean("greetingProxy");
        //greetingProxy.sayHello("sss");
    }
}
