package com.lwptest.basic.JVM;

/**
 * Created by liwanping on 2018-03-04
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JvmBlockDemo {
    private static List<int[]> bigObj = new ArrayList<int[]>();

    private static List<char[]> bigCharObj = new ArrayList<char[]>();

    private static int[] generate1MInt() {
        return new int[1024 * 256];
    }

    private static int[] generate1MChar() {
        return new int[1024 * 1024];
    }


    //-verbose:gc -Xms60M -Xmx60M -Xmn30M -XX:SurvivorRatio=8 -XX:-PrintGCDetails -XX:+PrintGCTimeStamps
    public static void main(String[] args) throws InterruptedException, IOException {
        int i = 0;
        while (i < 100) {
            if (i == 0) {
                //com.lwptest.Basic.Thread.sleep(15000);
                System.out.println("start=[" + new Date() + "]");
            } else {
                Thread.sleep(3000);
            }
            bigObj.add(generate1MInt());
            i++;
            /*if (i % 2 == 0) {
                bigCharObj=new ArrayList<char[]>();
                System.out.println("release obj!=[" + new Date() + "]");
            }*/
        }
        System.in.read();
    }
}