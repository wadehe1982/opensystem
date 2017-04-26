package com.xxx.opensys.test;

public class PrintOddAndEven {

	public static void main(String[] args) {
		
		Num num = new Num(1);

		P1 p1 = new P1(num);
		P2 p2 = new P2(num);
		
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		
		t1.start();
		t2.start();
	}

}

class P1 implements  Runnable {
	private Num num;
	P1(Num num){
		this.num = num;
	}
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		num.printEven();
		}
	}
}

class P2 implements  Runnable {
	private Num num;
	
	P2(Num num){
		this.num = num;
	}
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		num.printOdd();
		}
	}
}

class Num {
	int num;

	Num(int num) {
		this.num = num;
	}

	public synchronized void printOdd() {
		System.out.println(num++);

		try {
			this.notifyAll();
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void printEven() {
		System.out.println(num++);

		try {
			this.notifyAll();
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
