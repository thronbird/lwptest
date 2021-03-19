package com.lwp.java.basic.thread.ThreadLocal;

/**
  from 从零开始写javaweb框架
 */
public class ClientThread extends  Thread{
    private Sequence seq;



    public ClientThread(Sequence seq) {
        this.seq = seq;
    }

    @Override
    public void run() {
        for(int i=0;i<3;i++){
            System.out.println(Thread.currentThread().getName()+"==>"+seq.getNumber());
        }
    }
}
