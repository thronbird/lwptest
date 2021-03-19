package com.lwp.java.basic.JVM.MemoryTest;

/**
 * @author liwanping
 * @date 2018-07-29
 */
public class test {
    /*public static void main (String[] args ){
        long maxMem = Runtime.getRuntime().maxMemory()/1024;
        long freeMem = Runtime.getRuntime().freeMemory()/1024;
        System.out.println(maxMem);
        System.out.println(freeMem);
        Double brn=1018060813372110001.00;
        *//*HashMap<String , Integer> map = new HashMap<>();
        for(int i=0;i<300000;i++){
            brn=brn+1;
            map.put(String.valueOf(brn),1);
        }*//*
        HashMap<String , Integer> map = new HashMap<>();
        for(int i=0;i<300000;i++){
            brn=brn+1;
            map.put(String.valueOf(brn),1);
        }
        long maxMem2 = Runtime.getRuntime().maxMemory()/1024;
        long freeMem2 = Runtime.getRuntime().freeMemory()/1024;
        System.out.println(maxMem2);
        System.out.println(freeMem2);
    }*/

    public static Integer calculateNeedWeight(Integer weight,Integer height,Integer targetBMI){
        Double currentBMI = 10000*weight/new Double(height)/new Double(height);
        Integer currentWeight = weight;
        while(weight > 0 ){
            weight = weight - new Integer(1);
            Double tmpBMI  = 10000*weight/new Double(height)/new Double(height);
            if(tmpBMI < new Double(targetBMI) ){
                return currentWeight-weight;
            }
        }
        throw  new RuntimeException("error");
    }

    public static void main (String[] args ){
        System.out.println(calculateNeedWeight(90,180,23));
    }
}
