package com.xxx.opensys.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {

	public static void main(String[] args) {

		 final Lock lock = new ReentrantLock(true); //create fair lock
         //after running this code change it to
         //ReentrantLock(false); to see what happen
		// This is the first block of code
		    Thread thread = new Thread() {
		        public void run() {
		            for (int i = 0; i < 10; i++) {
		                lock.lock();
		                try{
		                	System.out.println("1111");
		                }catch(Exception e){
		                	
		                }finally {
		                	 lock.unlock();
						}
		            }
		        }

		    };
		    // This is the second block of code
		    Thread threadTwo = new Thread() {
		        public void run() {
		            for (int i = 0; i < 10; i++) {
		            	
		                lock.lock();
		                System.out.println("this: 2222");
		                lock.unlock();
		            }
		        }

		    };
		    // This is the second block of code
		    Thread threadThree = new Thread() {
		        public void run() {
		            for (int i = 0; i < 10; i++) {
		            	
		                lock.lock();
		                System.out.println("this is: 333333");
		                lock.unlock();
		            }
		        }

		    };
		 // These two statements are in the main method and begin the two
		    // threads.
		    // This is the third block of code
		    thread.start();

		    // This is the fourth block of code
		    threadTwo.start();
		    
		    threadThree.start();
	}

}
