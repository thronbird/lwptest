package com.lwp.java.basic.JVM;

import java.util.ArrayList;
import java.util.List;

public class TestG1 {

	//G1和CMS GC非常类似，只是G1将JVM划分为更小粒度的regions，并在回收时进行了估算。
	//-Xms40M -Xmx40M -Xmn20M -verbose:gc -XX:+Unlock -ExperimentalVMOptions -XX:MaxGCPauseIntervalMillis=1000 -XX:+PrintGCDetail
	public static void main(String[] args) throws InterruptedException {
		List<MemoryObject> objects = new ArrayList<MemoryObject	>();
		for(int i=0; i<20; i++) {
			objects.add(new MemoryObject(1024*1024));
			if(i%3==0) {
				objects.remove(0);
			}
		}
		Thread.sleep(2000);
	}
}
