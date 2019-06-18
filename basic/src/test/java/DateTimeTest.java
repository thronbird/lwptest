import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

import java.util.Date;

/**
 * @author liwanping
 * @date 2018-05-11
 */
public class DateTimeTest {
    public static void main (String[] args ){
        //900000
        System.out.println(new Date(new Date().getTime()-900000));
    }

    @Test
    public void test1(){
        System.out.println(        DateUtils.addHours(new Date(), -10));
        System.out.println(        DateUtils.addSeconds(new Date(), -30));
        System.out.println(        new Date());
    }
}
