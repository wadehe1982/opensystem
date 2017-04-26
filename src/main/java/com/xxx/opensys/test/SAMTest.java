package com.xxx.opensys.test;

@FunctionalInterface
public interface SAMTest {
	
	void run();
	
	default void another(){System.out.println("test");}

}
