package com.xxx.opensys.test;

import java.io.Serializable;

public class Singleton{
	
	private static volatile Singleton instance;
	public  static Singleton getInstance(){
		//双重检验锁
		if(instance == null){
			synchronized(Singleton.class){
				if(instance == null){
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	private Singleton(){
	}
}
