package com.lwp.java.basic.concurrency.thread;

/**
 * @author liwanping
 * @since 2019-07-22
 */
public class ProducerConsumerTest {
    private static class Tmall{

        private int MAX_COUNT = 10;
        private int storage = 0;

        synchronized void produce(){
            if(storage > MAX_COUNT){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            storage ++;
        }
        synchronized void consume(){
            storage--;
        }
    }

    private class Procucer{
        private Tmall tmall;
        void prod(){
            tmall.produce();
        }
    }
    private class Consumer{
        private Tmall tmall;
        void cons() throws InterruptedException {
            tmall.consume();
        }
    }

    public static void main (String[] args ){
        Tmall tmall = new Tmall();
        new Thread(()->{
            tmall.produce();
        });
        new Thread(()->{
            tmall.consume();
        });
    }

}
