package com.lwptest.basic.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author liwanping
 * @since 2019-07-18
 */
public class CallableAndFuture {
    private static ExecutorService ex = Executors.newFixedThreadPool(1);

    public static void main (String[] args ) throws ExecutionException, InterruptedException {
        Callable call = ()->{
            System.out.println("ddd");
            return "test";
        };
        Future<String> fu = ex.submit(call);
        System.out.println(fu.get());
    }
}
