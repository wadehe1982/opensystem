package com.xxx.opensys.test.deadlock;

import java.util.concurrent.locks.Lock;

import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Thread1 implements Runnable {
	
	@Setter
	private Lock lock1;
	@Setter
	private Lock lock2;
	@Setter
	private int shared;
	
	public Thread1(Lock lock1, Lock lock2, int shared) {
		super();
		this.lock1 = lock1;
		this.lock2 = lock2;
		this.shared = shared;
	}

	@Override
	public void run() {
		lock1.lock();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		lock2.lock();
		try{
			shared ++;
			System.out.println(shared);
		}catch(Exception e){
			
		}finally{
			lock2.unlock();
			lock1.unlock();
		}
	}

}
