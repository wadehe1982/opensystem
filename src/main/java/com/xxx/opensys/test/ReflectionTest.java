package com.xxx.opensys.test;

public class ReflectionTest {

	public static void main(String[] args) {
		

			try {
				User.class.newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			} 
	}
}
