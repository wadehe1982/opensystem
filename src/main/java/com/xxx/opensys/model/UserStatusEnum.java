package com.xxx.opensys.model;

import lombok.Getter;

public enum UserStatusEnum {
	
	ACTIVE(2,"ACTIVE"),
	INACTIVE(3,"INACTIVE");
	
	@Getter
	private int order;
	@Getter
	private String name;
	
	UserStatusEnum(int order, String name){
		this.order = order;
		this.name = name;
	}

}
