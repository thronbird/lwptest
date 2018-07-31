package JVM.MemoryTest;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * @author liwanping
 * @date 2018-07-29
 */
public class test {
    public static void main (String[] args ){
        long maxMem = Runtime.getRuntime().maxMemory()/1024;
        long freeMem = Runtime.getRuntime().freeMemory()/1024;
        System.out.println(maxMem);
        System.out.println(freeMem);
        Double brn=1018060813372110001.00;
        HashMap<String , Integer> map = new HashMap<>();
        for(int i=0;i<50000;i++){
            brn=brn+1;
            map.put(String.valueOf(brn),1);
        }
        long maxMem2 = Runtime.getRuntime().maxMemory()/1024;
        long freeMem2 = Runtime.getRuntime().freeMemory()/1024;
        System.out.println(maxMem2);
        System.out.println(freeMem2);
    }
}
