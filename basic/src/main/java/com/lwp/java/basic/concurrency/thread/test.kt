package com.lwp.java.basic.concurrency.thread

import java.util.*
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.stream.Collectors

fun main() {
    val taskExecutor = Executors.newFixedThreadPool(10)

    val list = listOf(1,2,3,2,1,2)

    // 下载代码、清理本地分支、checkout代码
    val futures = list.map {
        CompletableFuture.supplyAsync({
            TimeUnit.SECONDS.sleep(10)
        }, taskExecutor)
    }

    futures.stream()
            .map { obj -> obj.join() }
            .filter(Objects::nonNull)
            .collect(Collectors.toList())
    print("over")
    taskExecutor.shutdown()
}
