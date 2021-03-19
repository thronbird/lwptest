package com.lwp.java.basic.thread.ThreadLocal;

public class SequenceB implements Sequence{

    public static ThreadLocal<Integer> numberContainer =new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
           // Collections.synchronizedMap();
        }
    };

    public int getNumber() {
        numberContainer.set(numberContainer.get()+1);
        return numberContainer.get();
    }

    public static void main (String[] args ){
        Sequence  sequence= new SequenceB();
        ClientThread cli1=new ClientThread(sequence);
        ClientThread cli2=new ClientThread(sequence);
        ClientThread cli3=new ClientThread(sequence);
        cli1.start();
        cli2.start();
        cli3.start();
       // System.out.println();
    }
}
