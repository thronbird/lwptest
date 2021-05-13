package com.lwp.java.basic.JVM;

import lombok.val;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class HeapSize {
    public static void main(String[] args) {
        float a = (1002 -1000 )/1000f;
        System.out.println(a);

        long heapSize = Runtime.getRuntime().totalMemory();
        System.out
                .println("Current heap size in MB: " + heapSize / 1000 / 1000);


        long heapMaxSize = Runtime.getRuntime().maxMemory();
        System.out
                .println("Maximum heap size in MB: " + heapMaxSize / 1000 / 1000);

        long heapFreeSize = Runtime.getRuntime().freeMemory();
        System.out
                .println("heap free size in MB: " + heapFreeSize / 1000 / 1000);
    }
}
