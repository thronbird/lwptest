package com.lwp.java.basic.lock;

import java.util.*;

class SafeArrayList<T> {
    // 封装 ArrayList
    List<T> c = new ArrayList<>();

    // 控制访问路径
    synchronized T get(int idx) {
        return c.get(idx);
    }

    synchronized void add(int idx, T t) {
        c.add(idx, t);
    }

    synchronized boolean addIfNotExist(T t) {
        if (!c.contains(t)) {
            c.add(t);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // jdk 实现：
        List list = Collections.
                synchronizedList(new ArrayList());
        Set set = Collections.
                synchronizedSet(new HashSet());
        Map map = Collections.
                synchronizedMap(new HashMap());

        // Vector、Stack 和 Hashtable 不是基于包装类实现的
    }
}