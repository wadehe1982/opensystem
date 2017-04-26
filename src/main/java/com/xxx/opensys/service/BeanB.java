package com.xxx.opensys.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class BeanB {
	
	private BeanA a;
	
	@Autowired
	public BeanB(BeanA a) {
		super();
		this.a = a;
	}


	@PostConstruct
	public void test(){
		System.out.println("BeanB" + a);
	}

}
