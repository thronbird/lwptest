package GC;

/**
 * Created by liwanping on 2018-02-23
 */
class MemoryObject{
        private byte[] bytes;
        public MemoryObject(int objectSize){
                this.bytes=new byte[objectSize];
        }
}
