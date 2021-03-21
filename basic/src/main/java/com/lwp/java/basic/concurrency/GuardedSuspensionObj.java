package com.lwp.java.basic.concurrency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

/**
 * mq 异步转同步
 * // 处理浏览器发来的请求
 * Respond handleWebReq(){
 * int id= 序号生成器.get();
 * // 创建一消息
 * Message msg1 = new
 * Message(id,"{...}");
 * // 创建 GuardedSuspensionObj 实例
 * GuardedSuspensionObj<Message> go=
 * GuardedSuspensionObj.create(id);
 * // 发送消息
 * send(msg1);
 * // 等待 MQ 消息
 * Message r = go.get(
 * t->t != null);
 * }
 * void onMessage(Message msg){
 * // 唤醒等待的线程
 * GuardedSuspensionObj.fireEvent(
 * msg.id, msg);
 * }
 */
public class GuardedSuspensionObj<T> {
    // 保存所有 GuardedSuspensionObj
    final static Map<Object, GuardedSuspensionObj>
            gos = new ConcurrentHashMap<>();
    final Lock lock =
            new ReentrantLock();
    final Condition done =
            lock.newCondition();
    final int timeout = 2;
    // 受保护的对象
    T obj;

    // 静态方法创建 GuardedSuspensionObj
    static <K> GuardedSuspensionObj
    create(K key) {
        GuardedSuspensionObj go = new GuardedSuspensionObj();
        gos.put(key, go);
        return go;
    }

    static <K, T> void
    fireEvent(K key, T obj) {
        GuardedSuspensionObj go = gos.remove(key);
        if (go != null) {
            go.onChanged(obj);
        }
    }

    // 获取受保护对象
    T get(Predicate<T> p) {
        lock.lock();
        try {
            //MESA 管程推荐写法
            while (!p.test(obj)) {
                done.await(timeout,
                        TimeUnit.SECONDS);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
        // 返回非空的受保护对象
        return obj;
    }

    // 事件通知方法
    void onChanged(T obj) {
        lock.lock();
        try {
            this.obj = obj;
            done.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
