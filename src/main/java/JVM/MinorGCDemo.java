package JVM;

public class MinorGCDemo {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
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
