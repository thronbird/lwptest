package JVM;

public class PSGCDirectOldDemo {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
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
