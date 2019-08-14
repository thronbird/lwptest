package com.lwptest.basic.JVM;

public class PSGCDirectOldDemo {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
		/*S0     S1     E      O      M     CCS    YGC     YGCT    FGC    FGCT     GCT
		0.00   0.00  33.35   0.00  17.44  19.76      0    0.000     0    0.000    0.000
		0.00   0.00  58.35   0.00  17.44  19.76      0    0.000     0    0.000    0.000
		0.00   0.00  83.35   0.00  17.44  19.76      0    0.000     0    0.000    0.000
		0.00  82.67  25.00  40.08  66.59  68.88      1    0.003     0    0.000    0.003
		0.00  82.67  25.00  40.08  66.59  68.88      1    0.003     0    0.000    0.003*/

		byte[] bytes = new byte[1024*1024*2];
		byte[] bytes2 = new byte[1024*1024*2];
		byte[] bytes3 = new byte[1024*1024*2];
		
		System.out.println("ready to direct allocate to old");
		
		Thread.sleep(10000);
		
		byte[] bytes4 = new byte[1024*1024*4];
		Thread.sleep(3000);
		
		//以-Xms20M -Xmn10M -Xmx20M -XX:SurvivorRatio=8 -XX:+UseParallelGC执行以上代码，jstat可
		//查看到，bytes直接在旧生代上分配了。
	}
}
