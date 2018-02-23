package GC;

public class TestMinorGC {
	public static void main(String[] args) throws Exception{
	     MemoryObject object=new MemoryObject(1024*1024);
                     happenMinorGC(11);
                     Thread.sleep(2000);

        }

        private static void happenMinorGC(int happenMinorGCIndex) throws Exception{
             for(int i=0;i<happenMinorGCIndex;i++){
                 if(i==happenMinorGCIndex-1){
                     Thread.sleep(2000);
                     System.out.println("minor gc should happen");
                 }
                 new MemoryObject(1024*1024);
             }
        }
}
