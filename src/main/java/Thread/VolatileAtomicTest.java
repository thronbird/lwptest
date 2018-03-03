package Thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by liwanping on 2018-03-03
 */
public class VolatileAtomicTest {
     int i = 0;

    void add(){
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileAtomicTest  volatileAtomicTest = new VolatileAtomicTest();
        CountDownLatch countDownLatch= new CountDownLatch(10000);
        for (int j = 0; j < 10000; j++) {
            new Thread() {
                @Override
                public void run() {
                    volatileAtomicTest.add();
                    countDownLatch.countDown();
                }
            }.start();
        }
        countDownLatch.await();
        System.out.println(volatileAtomicTest.i);
    }

}
