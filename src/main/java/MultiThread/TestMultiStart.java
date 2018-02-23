package MultiThread;

/**
 * Created by liwanping on 2018-02-23
 */
public class TestMultiStart {
    public static void main (String[] args ){
        Thread x= new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("34242134");
            }
        });
        x.start();
        x.start();
    }
}
