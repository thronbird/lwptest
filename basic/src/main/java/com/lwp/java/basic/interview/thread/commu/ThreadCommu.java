package com.lwp.java.basic.interview.thread.commu;

import org.apache.commons.lang.StringUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ---------------------
 * 作者：扬帆舟
 * 来源：CSDN
 * 原文：https://blog.csdn.net/zhoufanyang_china/article/details/86667897
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 */
public class ThreadCommu {

    private static int index = 1;
    private static int endValue = 100;
    private static AtomicInteger count = new AtomicInteger(0);

    private static ExecutorService executor = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        boolean isLoop = true;
        while (isLoop) {
            if (count.get() > endValue) {
                isLoop = false;
                break;
            }
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (count.get() > endValue) {
                            return;
                        }
                        String name = Thread.currentThread().getName();
                        int j = Integer.parseInt(StringUtils.substring(name, name.length() - 1, name.length()));
                        if (j == index) {
                            System.out.println("线程（" + Thread.currentThread().getName() + "）" + (count.getAndIncrement()));

                            if (index == 3) {
                                index = 1;
                            } else {
                                index++;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executor.shutdown();
    }
}
