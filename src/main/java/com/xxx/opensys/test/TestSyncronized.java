package com.xxx.opensys.test;

public class TestSyncronized {

	private static Object lock = new Object();

	public static void main(String[] args) {
		m1();
	}

	public static void m1() {

		Thread t1 = new Thread(new Runnable() {

			public void run() {
				m2();
			}
		});
		t1.start();

		synchronized (lock) {
			try {
				Thread.sleep(2000);
				System.out.println("main");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void m2() {
		synchronized (lock) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("xxx");
		}
	}

}
