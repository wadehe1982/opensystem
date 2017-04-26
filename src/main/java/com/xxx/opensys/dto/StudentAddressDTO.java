package com.xxx.opensys.dto;

import javax.persistence.Column;

import lombok.Data;

@Data
public class StudentAddressDTO {
	
	
    private long studentAddressId;
	
	private String address1;
	
	private String address2;
	
	private String zipcode;

}
