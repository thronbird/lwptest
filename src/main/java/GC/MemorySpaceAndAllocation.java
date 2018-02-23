package GC;

public class MemorySpaceAndAllocation{
    public static void main(String[] args) throws Exception{
        Thread.sleep(2000);
        // should allocate from TLAB
        MemoryObjectx object=new MemoryObjectx(new byte[1024]);
        Thread.sleep(2000);
        // should allocate from Eden space,not TLAB
        MemoryObjectx newObject=new MemoryObjectx(new byte[1024*1024*4]);
        Thread.sleep(2000);
        System.gc();
        Thread.sleep(2000);
        object=new MemoryObjectx(new byte[1024]);
        Thread.sleep(2000);
        // should allocate from Eden space,not TLAB
        newObject=new MemoryObjectx(new byte[1024*1024*4]);
        Thread.sleep(2000);
        System.gc();
        Thread.sleep(2000);
    }
}

class MemoryObjectx{
    private byte[] bytes;
    public byte[] getBytes(){
        return bytes;
    }
    public MemoryObjectx(byte[] bytes){
        this.bytes=bytes;
    }
}
