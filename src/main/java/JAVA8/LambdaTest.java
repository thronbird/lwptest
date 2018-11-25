package JAVA8;

import ArtConcurrentBook.chapter04.Interrupted;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author liwanping
 * @date 2018-05-24
 */
public class LambdaTest {
    public static void teststr(String x){
        System.out.println("dasdsad");
    }

    @Test
    public void listTest(){
        List<String> x= Arrays.asList("3231","bbb","uuu");
        //forEach多态--不用关注实现细节--（不用关注边界条件 循环处理 等等）
        x.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
       x.forEach((String y)-> System.out.println(y+"p"));
       //%99的情况下java可推断出类型 不用声明lambda表达式中的type info
        x.forEach(y-> System.out.println(y+"p"));
        //参数可省略 传入类的方法
        x.forEach(System.out::println);//method refrence to a instance
        x.forEach(String::valueOf);//refrence to a static method
        x.forEach(LambdaTest::teststr);//method refrence to a instance
        x.forEach(String::toString);//method refrence to a instance

        List<Integer> xx= Arrays.asList(1,2,3,9,4);
        //同时存在instance method &static method 编译能通过 但是运行时会报错：无法推断出方法--因为有两个备选
        //System.out.println(xx.stream().map(Integer::toString));
        //指定方法即可
        System.out.println(xx.stream().map(e->Integer.toString(e)));
        System.out.println(xx.stream().reduce(0,(total,e)->Integer.sum(total,e)));
        System.out.println("reduce ="+xx.stream().reduce(0,(total,e)->Integer.max(total,e)));
        //System.out.println(xx.stream().reduce(0,Integer::sum));
        //xx.stream().filter()
        System.out.println("collector ="+ xx.stream().filter(e -> e % 2 == 0).collect(Collectors.toList()));
        System.out.println(Stream.iterate(0, e -> e+1).limit(44).toArray().length);
        new Thread(()-> System.out.println("xxxxxx")).run();
    }

    @Test
    public void test2(){
        Supplier<Runnable> c = () -> () -> { System.out.println("hi"); };
        c.get().run();
    }
    @Test
    public void mains (){
        Integer[] a = {1,2};
        List<Integer> x  = Arrays.asList(a);
        System.out.println(x);
    }
}
