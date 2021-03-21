package com.lwp.java.basic.concurrency.thread;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {
    public static void main(String[] args) {
        exception2();
    }

    public static void test() {
        CompletableFuture<String> f0 =
                CompletableFuture.supplyAsync(
                        () -> "Hello World")      //①
                        .thenApply(s -> s + " QQ")  //②
                        .thenApply(String::toUpperCase);//③

        System.out.println(f0.join());
    }

    public static void test2() {
//        CompletableFuture<String> f1 =
//                CompletableFuture.supplyAsync(()->{
//                    int t = getRandom(5, 10);
//                    sleep(t, TimeUnit.SECONDS);
//                    return String.valueOf(t);
//                });
//
//        CompletableFuture<String> f2 =
//                CompletableFuture.supplyAsync(()->{
//                    int t = getRandom(5, 10);
//                    sleep(t, TimeUnit.SECONDS);
//                    return String.valueOf(t);
//                });
//
//        CompletableFuture<String> f3 =
//                f1.applyToEither(f2,s -> s);
//
//        System.out.println(f3.join());
    }

    public static void exception() {
        CompletableFuture<Integer>
                f0 = CompletableFuture
                .supplyAsync(() -> 7 / 0)
                .thenApply(r -> r * 10)
                .exceptionally(e -> 0);
        System.out.println(f0.join());
    }


    public static void exception2() {
        CompletableFuture<Integer>
                f0 = CompletableFuture
                .supplyAsync(() -> {
                    throw new RuntimeException("skskjdslkaj");
                });
        try {

            System.out.println(f0.join());
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    }
}
