import org.junit.Test;

/**
 * @author liwanping
 * @date 2018-06-27
 */
public class ExceptionTest {

    public static void throwRuntimeException() {
        throw  new RuntimeException("sss");
    }

    public static void throwGeneralExecption() throws Exception{
        throw  new RuntimeException("sss");
    }

    @Test
    public  void test0 () {
        try {
            throwRuntimeException();
        }catch (Exception e){
            System.out.println("hgh"+e.getMessage());
            return;
        }
        System.out.println("xxx");
    }

    @Test
    public  void test2(){
        try{
            throwGeneralExecption();
        }catch (RuntimeException e){
            System.out.println("xxx");
        }catch (Exception e){
            System.out.println("yyy");
        }
    }

    @Test
    public  void test3(){
        int i=0;
        while(true){
            i++;
            System.out.println(i);
            if(i==3){
               /* try {*/
                    throwRuntimeException();
                /*}catch (RuntimeException e){
                    System.out.println(e);
                }*/
            }
        }
    }
}
