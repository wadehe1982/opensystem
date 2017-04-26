package com.xxx.opensys.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class BeanA {
	
	private BeanB b;
	
	@Autowired
	public BeanA(BeanB b) {
		super();
		this.b = b;
	}


	@PostConstruct
	public void test(){
		System.out.println("BeanA" + b);
	}

}
