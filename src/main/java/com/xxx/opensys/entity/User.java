package com.xxx.opensys.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.xxx.opensys.dto.UserDTO;
import com.xxx.opensys.model.UserStatusEnum;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "user")
@Getter
@Setter
//@Cacheable
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userId")
	private int id;
	@Column(name="name")
	private String userName;
	@Column(name="password")
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="addressId")
	private Address address;
	
	@Column(name="activated")
	private boolean activated;
	
	@Column(name="createdAt")
	private LocalDateTime createdAt = LocalDateTime.now();
	
	@Column(name="status")
	private UserStatusEnum status;
	
	public User(UserDTO dto) {
		this.address = dto.getAddress();
		this.password = dto.getPassword();
		this.userName = dto.getUserName();
		this.activated = dto.isActivated();
		this.createdAt = dto.getCreatedAt();
		this.status = dto.getStatus();
		this.id = dto.getId();
	}


	public UserDTO toDto(){
		UserDTO userDTO = new UserDTO();
		userDTO.setAddress(this.address);
		userDTO.setId(this.id);
		userDTO.setPassword(this.password);
		userDTO.setUserName(this.userName);
		userDTO.setStatus(this.status);
		return userDTO;
	}

	public User() {
		super();
	}
}
