package JVM;

import java.util.ArrayList;
import java.util.List;

public class TestCMSGC {

	//Full GC示例：CMS GC失败触发的Full GC
	//以-Xms20M -Xmx20M -Xmn10M -verbose:gc -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC执行以上代码，观察输出的日志
	public static void main(String[] args) throws InterruptedException {
		List<MemoryObject> objects = new ArrayList<MemoryObject>(6);
		for(int i=0; i<9; i++) {
			objects.add(new MemoryObject(1024*1024));
		}
		Thread.sleep(2000);
		objects.remove(0);
		objects.remove(0);
		objects.remove(0);
		for(int i=0; i<20; i++) {
			objects.add(new MemoryObject(1024*1024));
			if(i%2==0) {
				objects.remove(0);
			}
		}
		Thread.sleep(5000);
	}
}
