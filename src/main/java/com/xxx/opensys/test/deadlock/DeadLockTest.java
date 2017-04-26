package com.xxx.opensys.test.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockTest {
	
	private static Lock lock1 = new ReentrantLock();
	private static Lock lock2 = new ReentrantLock();
	private static int shared = 0;

	public static void main(String[] args) {
		
//		Thread1 t1 = new Thread1(lock1,lock2, shared);
		Thread1 t1 = new Thread1();
		t1.setLock1(lock1);
		t1.setLock2(lock2);
		t1.setShared(shared);
		
//		Thread2 t2 = new Thread2(lock1,lock2, shared);
		Thread2 t2 = new Thread2();
		
		t2.setLock1(lock1);
		t2.setLock2(lock2);
		t2.setShared(shared);
	
		
		new Thread(t1).start();
		new Thread(t2).start();
	}

}
