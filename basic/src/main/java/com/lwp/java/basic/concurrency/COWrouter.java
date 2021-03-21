package com.lwp.java.basic.concurrency;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

class CowRouter {
}

// 路由信息
final class Router {
    final String iface;
    private final String ip;
    private final Integer port;

    // 构造函数
    public Router(String ip,
                  Integer port, String iface) {
        this.ip = ip;
        this.port = port;
        this.iface = iface;
    }

    // 重写 equals 方法
    public boolean equals(Object obj) {
        if (obj instanceof Router) {
            Router r = (Router) obj;
            return iface.equals(r.iface) &&
                    ip.equals(r.ip) &&
                    port.equals(r.port);
        }
        return false;
    }

    public int hashCode() {
        // 省略 hashCode 相关代码
        return 0;
    }
}

// 路由表信息
class RouterTable {
    //Key: 接口名
    //Value: 路由集合
    ConcurrentHashMap<String, CopyOnWriteArraySet<Router>>
            rt = new ConcurrentHashMap<>();

    // 根据接口名获取路由表
    public Set<Router> get(String iface) {
        return rt.get(iface);
    }

    // 删除路由
    public void remove(Router router) {
        Set<Router> set = rt.get(router.iface);
        if (set != null) {
            set.remove(router);
        }
    }

    // 增加路由
    public void add(Router router) {
        Set<Router> set = rt.computeIfAbsent(
                router.iface, r ->
                        new CopyOnWriteArraySet<>());
        set.add(router);
    }
}