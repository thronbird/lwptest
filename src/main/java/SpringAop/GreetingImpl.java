package SpringAop;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/3/22.
 */
@Component
public class GreetingImpl implements Greeting {

    public void sayHello(String name) {
        System.out.println("hello,"+name);
      //  throw new RuntimeException("hsdakhdkashdka");
    }

    public void goodMorning(String name) {
        System.out.println("good morning:" + name);
    }

    public void goodNight(String name) {
        System.out.println("good nigth:" + name);
    }

    // 要对以上代码进行重构，有三种方法
    // jdk动态代理
    // 静态代理
    // cglib动态代理

}
