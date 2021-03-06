package com.lwp.java.basic.concurrency;

import java.util.concurrent.atomic.AtomicReference;

public class SafeWM {
    final AtomicReference<WMRange> rf = new AtomicReference<>(
            new WMRange(0, 0)
    );

    // 设置库存上限
    void setUpper(int v) {
        while (true) {
            WMRange or = rf.get();
            // 检查参数合法性
            if (v < or.lower) {
                throw new IllegalArgumentException();
            }
            WMRange nr = new
                    WMRange(v, or.lower);
            if (rf.compareAndSet(or, nr)) {
                return;
            }
        }
    }

    class WMRange {
        final int upper;
        final int lower;

        WMRange(int upper, int lower) {
            this.lower = lower;
            this.upper = upper;
            // 省略构造函数实现

        }
    }
}
