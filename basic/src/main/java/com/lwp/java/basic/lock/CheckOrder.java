package com.lwp.java.basic.lock;

import java.util.Vector;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier
 *
 * @param <P>
 * @param <D>
 */
public class CheckOrder<P, D> {
    // 订单队列
    Vector<P> pos;
    // 派送单队列
    Vector<D> dos;
    // 执行回调的线程池
    Executor executor =
            /* 设置线程池为单个线程可以保证对账的操作按顺序执行
            线程池大小为1是必要的，如果设置为多个，有可能会两个线程 A 和 B 同时查询，A 的订单先返回，B 的派送单先返回，造成队列中的数据不匹配；所以1个线程实现生产数据串行执行，保证数据安全
        如果用Future 的话可以更方便一些：
        CompletableFuture<List> pOrderFuture = CompletableFuture.supplyAsync(this::getPOrders);
        CompletableFuture<List> dOrderFuture = CompletableFuture.supplyAsync(this::getDOrders);
        pOrderFuture.thenCombine(dOrderFuture, this::check)
                    .thenAccept(this::save);
             */
            Executors.newFixedThreadPool(1); //
    final CyclicBarrier barrier =
            new CyclicBarrier(2, () -> {
                executor.execute(() -> check());
            });

    void check() {
        P p = pos.remove(0);
        D d = dos.remove(0);
        // 执行对账操作
        // diff = check(p, d);
        // 差异写入差异库
        // save(diff);
    }

//    void checkAll(){
//        // 循环查询订单库
//        Thread T1 = new Thread(()->{
//            while(存在未对账订单){
//                // 查询订单库
//                pos.add(getPOrders());
//                // 等待
//                barrier.await();
//            }
//        });
//        T1.start();
//        // 循环查询运单库
//        Thread T2 = new Thread(()->{
//            while(存在未对账订单){
//                // 查询运单库
//                dos.add(getDOrders());
//                // 等待
//                barrier.await();
//            }
//        });
//        T2.start();
//    }
}
