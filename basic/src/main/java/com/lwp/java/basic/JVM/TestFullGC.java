package com.lwp.java.basic.JVM;

import java.util.ArrayList;
import java.util.List;

public class TestFullGC {
	//Full GC示例：旧生代空间不足触发的Full GC
	//以-Xms20M -Xmx20M -Xmn10M -verbose:gc -XX:+PrintGCDetails执行以上代码，观察输出的日志
	public static void main(String[] args) throws InterruptedException {
		List<MemoryObject> objects = new ArrayList<MemoryObject>();
		for(int i=0; i<10; i++) {
			objects.add(new MemoryObject(1024*1024));
		}

		//让上面的对象尽可能地转入旧生代中
		System.gc();
		System.gc();
		Thread.sleep(2000);
		objects.clear();

		for(int i=0; i<10; i++) {
			objects.add(new MemoryObject(1024*1024));
			if(i%3==0) {
				objects.remove(0);
			}
		}
		Thread.sleep(5000);
	}
}
