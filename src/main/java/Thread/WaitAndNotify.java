package Thread;

/**
 * Created by liwanping on 2018-03-03
 */
public class WaitAndNotify {

    private class ThreadWait extends  Thread{

        private Object lock;

        @Override
        public void run() {
            synchronized (lock){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private class ThreadNotify extends  Thread{

        private Object lock;

        @Override
        public void run() {
            //synchronized (lo)
            lock.notify();
        }
    }

}
