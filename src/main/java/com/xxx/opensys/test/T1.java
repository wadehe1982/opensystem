package com.xxx.opensys.test;

public class T1 implements Runnable{

	public void run() {
		
		System.out.println("start sleep");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
