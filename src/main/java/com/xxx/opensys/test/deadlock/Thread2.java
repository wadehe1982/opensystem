package com.xxx.opensys.test.deadlock;

import java.util.concurrent.locks.Lock;

import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Thread2 implements Runnable {
	
	@Setter
	private Lock lock1;
	@Setter
	private Lock lock2;
	@Setter
	private int shared;
	
	public Thread2(Lock lock1, Lock lock2, int shared) {
		super();
		this.lock1 = lock1;
		this.lock2 = lock2;
		this.shared = shared;
	}

	@Override
	public void run() {
		lock2.lock();
		lock1.lock();
		try{
			shared = 2;
			System.out.println(shared);
		}catch(Exception e){
			
		}finally{
			lock1.unlock();
			lock2.unlock();
		}
	}

}
