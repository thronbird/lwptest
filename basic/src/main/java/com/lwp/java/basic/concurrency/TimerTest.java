package com.lwp.java.basic.concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TimerTest {

    public static void main(String[] args) {
        int delay = 1000;
        int period = 1000;
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                System.out.println("ssss");
            }
        }, delay, period);
        try{
            TimeUnit.SECONDS.sleep(10);
            System.out.println("32fsddzf");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            timer.cancel();
        }
    }
}
