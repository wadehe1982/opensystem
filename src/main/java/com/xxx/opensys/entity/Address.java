package com.xxx.opensys.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.xxx.opensys.dto.AddressDTO;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="address")
@Getter
@Setter
@Cacheable
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="addressId")
	private int addressId;
	
	@Column(name="address1")
	private String address1;
	
	@Column(name="address2")
	private String address2;
	
	@Column(name="zipcode")
	private String zipcode;
	
	public AddressDTO toDto(){
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setAddress1(this.address1);
		addressDTO.setAddress2(this.address2);
		addressDTO.setAddressId(this.addressId);
		addressDTO.setZipcoede(this.zipcode);
		return addressDTO;
	}
}
