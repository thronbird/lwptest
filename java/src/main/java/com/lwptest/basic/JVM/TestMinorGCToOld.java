package com.lwptest.basic.JVM;

public class TestMinorGCToOld {

	//Full GC示例：统计得到的Minor GC晋升到旧生代的平均大小大于旧生代的剩余空间
	//以java -Xms20M -Xmx20M -Xmn10M -verbose:gc -XX:+PrintGCDetails -XX:+UseParallelGC执行以上代码，观察输出的日志
	//以java -Xms20M -Xmx20M -Xmn10M -verbose:gc -XX:+PrintGCDetails -XX:+UseSerialGC执行以上代码，观察输出的日志
	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
		byte[] bytes = new byte[1024*1024*2];
		byte[] bytes2 = new byte[1024*1024*2];
		byte[] bytes3 = new byte[1024*1024*2];
		System.out.println("ready to happen one minor gc, if parallel scavenge gc, then should one full gc");
		byte[] bytes4 = new byte[1024*1024*2];
		Thread.sleep(3000);
		System.out.println("minor gc end");
		byte[] bytes5 = new byte[1024*1024*2];
		byte[] bytes6 = new byte[1024*1024*2];
		System.out.println("mimor gc again, and should direct full gc");
		byte[] bytes7 = new byte[1024*1024*2];
		Thread.sleep(3000);
	}
}
