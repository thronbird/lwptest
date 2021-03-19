package com.lwp.java.basic.JVM;

public class MinorGCDemo {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
		/*S0     S1     E      O      M     CCS    YGC     YGCT    FGC    FGCT     GCT
		0.00   0.00  22.94   0.00  17.44  19.76      0    0.000     0    0.000    0.000
		0.00   0.00  33.27   0.00  17.44  19.76      0    0.000     0    0.000    0.000
		*/
		//0.00   0.00  41.60   0.00  17.44  19.76      0    0.000     0    0.000    0.000

		MemoryObject object = new MemoryObject(1024*1024);
		for(int i=0; i<2; i++) {
			happenMinorGC(11);
			Thread.sleep(2000);
		}
		//-Xms40M -Xmx40M -Xmn16M -verbose:gc -XX:+PrintGCDetails参数执行
	}

	private static void happenMinorGC(int happenMinorGCIndex) throws InterruptedException {
		for(int i=0; i<happenMinorGCIndex; i++) {
			if(i==happenMinorGCIndex-1) {
				Thread.sleep(2000);
				System.out.println("minor gc should happen");
			}
			new MemoryObject(1024*1024);
		}
	}
}

class MemoryObject {
	@SuppressWarnings("unused")
	private byte[] bytes;
	public MemoryObject(int objectSize) {
		this.bytes = new byte[objectSize];
	}
}
