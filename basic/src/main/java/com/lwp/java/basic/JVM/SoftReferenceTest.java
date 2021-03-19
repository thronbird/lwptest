package com.lwp.java.basic.JVM;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class SoftReferenceTest {

	public static void main(String[] args) {

		//强引用的对象只有在主动释放了引用后才会被GC
		Object o = new Object();
		System.out.println(o);

		//采用软引用来建立引用的对象，当JVM内存不足时会被回收。SoftReference很适合用于实现缓存。
		//当GC认为扫描到的SoftReference不经常使用时，也会被回收，存活时间可通过-XX:SoftRefLRUPolicyMSPerMB来进行控制。
		Object object = new Object();
		SoftReference<Object> softRef = new SoftReference<Object>(object);
		System.out.println(softRef.toString());
		System.out.println(softRef.get());
		object = null;

		//弱引用采用WeakReference来实现，采用弱引用建立引用的对象没有强引用后，GC时即会被释放。
		Object object2 = new Object();
		WeakReference<Object> weakRef = new WeakReference<Object>(object2);
		object2 = null;
		System.out.println(weakRef.get());

		//虚引用采用PhantomReference来实现，采用虚引用可跟踪到对象是否已从内存中被删除。
		Object object3 = new Object();
		ReferenceQueue<Object> queue = new ReferenceQueue<Object>();
		PhantomReference<Object> phanRef = new PhantomReference<Object>(object3, queue);
		object3 = null;
		System.out.println(phanRef.get());
	}
}
