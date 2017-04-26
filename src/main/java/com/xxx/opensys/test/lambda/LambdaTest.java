package com.xxx.opensys.test.lambda;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import lombok.ToString;

@ToString
public class LambdaTest {
	
	private static Lock lock1 = new ReentrantLock();
	private static Lock lock2 = new ReentrantLock();
	private static int shared = 0;
	
	private int i = 0;
	
	private Thread t3 = new Thread(()->{
		this.i =9;
		i = 8;
		System.out.println(this);
	});
	
	private Thread t4 = new Thread(new Runnable(){
		public void run(){
			
			System.out.println(this);
		}
		@Override
		public String toString(){
			return "xxx";
		}
	});
	
	private static  Thread t1 = new Thread(new Runnable(){

		@Override
		public void run() {

			System.out.println(this);
			lock1.lock();
			System.out.println("T1-X got lock1!!!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("T1-X try to lock lock2");
			lock2.lock();
			System.out.println("T1-X got lock2!!!");
			try{
			shared ++;
			}catch(Exception e){
				
			}finally{
				System.out.println("T1-xxx try to unlock lock1/lock2");
				lock2.unlock();
				lock1.unlock();
				System.out.println("T1-XXX lock1/lock2 unlocked!!");
			}
		}
		
	});
	
	private static Thread t2 = new Thread(new Runnable(){

		@Override
		public void run() {
			
			try{
				System.out.println(this);
				lock2.lock();
				System.out.println("T2 got lock2!!!!");
				
				System.out.println("T2 try to get lock1.....");
				lock1.lock();
				shared ++;
				System.out.println("T2 got lock1!!!!");
				
			}catch(Exception e){
				
			}finally{
				lock2.unlock();
				lock1.unlock();
				System.out.println("T2- lock1/lock2 unlocked....");
			}
			
		}
		
	});
	
	@SuppressWarnings("unused")
	private void m1(Lock lock1, Lock lock2, int shared){
		Thread t1 = new Thread(new Runnable(){
			
			@Override
			public void run() {
				int i = 0;
				lock1.lock();
				
				System.out.println(this);
				System.out.println("T1 got lock1!!!");
				try{
					Thread.sleep(1000);
					System.out.println("T1 try to get lock2");
					lock2.lock();

					System.out.println("T1 got lock2!!!");
				}catch(Exception e){
					
				}finally{
					System.out.println("T2-xxx try to unlock lock1/lock2......");
					lock2.unlock();
					lock1.unlock();
					System.out.println("lock1/lock2 unlocked");
				}
			}
		});
		
		t1.setName("T1xxxx");
		t1.start();
	}
	
	private void m2(){
		
	}
	

	public static void main(String[] args) {
		
		LambdaTest test = new LambdaTest();
		
		test.t4.start();
		
//		t1.setName("T100");
//		t1.start();
//		
//		t2.setName("T200");
//		t2.start();
		
//		test.m1(lock1, lock2, shared);
		
		/*
		//anonymous inner class
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				lock1.lock();
				System.out.println("lock1 locked");
				try {
					System.out.println("t1 sleep");
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("t1 try to get lock2");
				lock2.lock();
				System.out.println("t1 got lock2");
				lock2.unlock();
				System.out.println("t1 unlocked lock2");
				lock1.unlock();
				System.out.println("t1 unlocked lock1");
			}
		});
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				
				System.out.println("t2 try to lock lock2");
				lock2.lock();
				System.out.println("t2 locked lock2");
				System.out.println("t2 try to lock lock1");
				lock1.lock();
				System.out.println("t2 locked lock1");
				
				lock1.unlock();
				System.out.println("t2 unlocked lock1");
				lock2.unlock();
				System.out.println("t2 unlocked lock1");
			
			}
			
		});
		t1.setName("T100");
		t1.start();
		t2.setName("T200");
		t2.start();
		*/
		
		//lambda expression
		/*
		Thread t1 = new Thread(()->{

        System.out.println("T1 try to get lock1");
        lock1.lock();
        System.out.println("T1 trgot lock1!!!");
        try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
        try{
        	System.out.println("T1 try to get lock2.....");
            lock2.lock();
            shared ++;
            System.out.println("T1 got lock2!!!");
        }catch(Exception e){
        	
        }finally{
        	System.out.println("try to unlock lock1/lock2!!!");
            
            lock2.unlock();
            lock1.unlock();
        }
		});
		t1.setName("T1");
		t1.start();
		
		Thread t2 = new Thread(()->{
			System.out.println("T2 try to get lock2");
			lock2.lock();
			System.out.println("T2 got lock2!!!");
			try {
				Thread.sleep(100);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try{
				System.out.println("T2 sleep finished...");
				System.out.println("T2 try to get lock1");
				lock1.lock();
				System.out.println("T2 got lock1!!!!!");
				shared ++;
			}catch(Exception e){
				
			}finally{
				lock1.unlock();
				lock2.unlock();
				System.out.println("T2 unlocked lock1/lock2!!!");
			}
		});
		
		t2.setName("T2");
		t2.start();
	*/
	}
	

}
