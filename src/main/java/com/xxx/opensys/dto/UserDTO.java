package com.xxx.opensys.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.xxx.opensys.entity.Address;
import com.xxx.opensys.model.UserStatusEnum;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String userName;
	private String password;
	private Address address;
	private boolean activated;
	private LocalDateTime createdAt;
	private UserStatusEnum status;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
