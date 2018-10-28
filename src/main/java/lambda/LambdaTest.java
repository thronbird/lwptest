package lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author liwanping
 * @date 2018-05-24
 */
public class LambdaTest {

    @Test
    public void listTest(){
        List<String> x= Arrays.asList("3231","bbb","uuu");
        x.forEach((String y)-> System.out.println(y+"p"));
        x.forEach(y-> System.out.println(y+"p"));
    }

    @Test
    public void test2(){
        Supplier<Runnable> c = () -> () -> { System.out.println("hi"); };
        c.get().run();
    }
}
