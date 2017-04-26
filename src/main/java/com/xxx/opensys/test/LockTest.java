package com.xxx.opensys.test;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

	public static void main(String[] args) {

		ReentrantLock l1 = new ReentrantLock();
		
		ReentrantLock l2 = new ReentrantLock();
		
		for (int i = 0; i < 100; i++){
			T t = new T(l1, l2);
			new Thread(t).start();
		}
	}
	
	public void m1(){
		synchronized (this) {
			try {
				Thread.currentThread().wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
class T implements Runnable{
	 
	 private ReentrantLock l1;
	 private ReentrantLock l2;
	 
	 

	public T(ReentrantLock l1, ReentrantLock l2) {
		super();
		this.l1 = l1;
		this.l2 = l2;
	}


	@Override
	public void run() {
		
		l1.lock();
		System.out.println("l1 QueueLength: " + l1.getQueueLength());
		System.out.println("l1 HoldCount: " + l1.getHoldCount());
		System.out.println("l1 owner: " + Thread.currentThread().getName());
		l2.lock();
		
		System.out.println("l2 QueueLength: " + l2.getQueueLength());
	
		System.out.println("l2 HoldCount: " + l2.getHoldCount());
		
		System.out.println("l2 owner: " + Thread.currentThread().getName());
		try{
			Thread.sleep(1000);
		System.out.println(Thread.currentThread().getName());
		}catch (Exception e){
			System.out.println(e);
		}finally{
			l2.unlock();
		}
		try{}catch(Exception e){}finally{l1.lock();}
		
	}
	 
}
