package com.xxx.opensys.test.lambda;

import lombok.Data;

@Data
public class UserEntity {

	private String name;
	
	private int age;
	
	public UserDTO valueOf(){
		UserDTO userDTO = new UserDTO();
		userDTO.setAge(age);
		userDTO.setName(name);
		return userDTO;
		
	}
}
