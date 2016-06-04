package com.xxx.opensys.dto;

import com.xxx.opensys.entity.Address;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
	
	private int id;
	private String userName;
	private String password;
	private Address address;
	private boolean activated;
}
