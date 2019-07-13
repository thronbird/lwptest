package com.lwptest.basic.JVM;

import org.apache.tools.ant.types.resources.selectors.Date;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liwanping
 * @since 2019-07-08
 */
public class OOMtest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            new Thread(() -> {
                while (true) {
                    System.out.println(new Date().getDatetime() + Thread.currentThread() + "==");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            List<byte[]> list = new ArrayList<byte[]>();
            System.out.println(new Date().toString() + "wait...");
            try {
                Thread.sleep(3000);//尝试等待第一次gc日志
                System.out.println(new Date().toString() + "start...");
                int i = 0;
                while (true) {
                    System.out.println(new Date().getDatetime() + Thread.currentThread() + ":"+(++i));
                    Thread.sleep(500);//方便打印出日志
                    int _1M = 1024 * 1024 * 1;
                    byte[] b = new byte[_1M];
                    list.add(b);
                    Thread.sleep(500);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.setName("OOM-thread");
        thread.start();

    }
}
