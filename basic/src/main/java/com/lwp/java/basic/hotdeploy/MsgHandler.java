package com.lwp.java.basic.hotdeploy;

/**
 * @title 后台线程
 * @describe 后台启动一条线程不断刷新加载实现了热加载的类
 * @author zc
 * @version 1.0 2017-12-01
 */
public class MsgHandler implements Runnable{

	@Override
	public void run() {
		while(true){
			BaseManager manager = ManagerFactory.getManager(ManagerFactory.MY_MANAGER);
			manager.logic();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
