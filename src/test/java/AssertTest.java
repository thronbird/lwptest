/**
 * @author liwanping
 * @date 2018-05-30
 * 开启assert： java -ea
 */
public class AssertTest {
    public static void main (String[] args ){
        String   a = "3";
        assert a == null:"assert error";
        System.out.println("5");
    }
}
