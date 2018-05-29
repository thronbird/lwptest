import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
}
